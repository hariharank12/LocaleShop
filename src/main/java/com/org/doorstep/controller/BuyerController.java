/**
 * 
 */
package com.org.doorstep.controller;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.org.doorstep.dto.BuyerDTO;
import com.org.doorstep.dto.BuyersDTO;
import com.org.doorstep.service.BuyerService;

/**
 * @author hariharank12
 *
 */
@Controller
@Singleton
@Path("/buyers")
public class BuyerController {

	@Autowired
	BuyerService buyerService;

	@Context
	private UriInfo uriInfo;

	@Context
	private Request request;

	@Autowired
	private ApplicationContext ctx;

	@Context
	private ServletContext servletContext;

	@GET
	@Path("/{id}")
	@Produces({ "text/plain", MediaType.APPLICATION_XML,
			MediaType.APPLICATION_JSON })
	public Response show(@PathParam("id") String id) {
		BuyerDTO buyerDTO = buyerService.getBuyer(Integer.parseInt(id));
		return Response.ok().entity(buyerDTO).build();
	}

	@Path("/")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response index() {
		BuyersDTO buyersDTO = new BuyersDTO();
		buyersDTO.getBuyers().addAll(buyerService.getAllBuyers());
		System.out.println("list of buyers " + buyersDTO.getBuyers().size());
		return Response.ok().entity(buyersDTO).build();
	}

	@Path("/")
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_JSON })
	public Response create(BuyerDTO buyerDTO) {
		System.out.println("buyer " + buyerDTO.getName());
		ResponseBuilder response;
		String message = "Buyer Successfully created";
		try {
			buyerService.createBuyer(buyerDTO);
			response = Response.ok(message, MediaType.TEXT_PLAIN);
		} catch (Exception e) {
			message = e.getMessage();
			response = Response.status(Response.Status.BAD_REQUEST)
					.type(MediaType.TEXT_PLAIN).entity(message);
		}
		return response.build();

	}

	@Path("/{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_JSON })
	public Response update(@PathParam("id") int id, BuyerDTO buyerDTO) {
		System.out.println("buyer " + buyerDTO.getName());
		String message = StringUtils.EMPTY;
		ResponseBuilder response;
		try {
			BuyerDTO buyer = buyerService.updateBuyer(id, buyerDTO);
			// response = Response.ok(buyer, MediaType.APPLICATION_JSON);
			response = Response.ok(buyer);
		} catch (Exception e) {
			message = e.getMessage();
			response = Response.status(Response.Status.BAD_REQUEST)
					.type(MediaType.TEXT_PLAIN).entity(message);
		}
		return response.build();
	}

}
