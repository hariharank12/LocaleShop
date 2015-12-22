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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.org.doorstep.dto.SellerDealDTO;
import com.org.doorstep.dto.SellerDealsDTO;
import com.org.doorstep.service.SellerDealService;

/**
 * @author hariharank12
 *
 */
@Controller
@Singleton
@Path("/deals")
public class SellerDealController {

	@Autowired
	SellerDealService sellerDealService;

	@Context
	private UriInfo uriInfo;

	@Context
	private Request request;

	@Autowired
	private ApplicationContext ctx;

	@Context
	private ServletContext servletContext;

	// @Path("/")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response index() {
		SellerDealsDTO sellerDealsDTO = new SellerDealsDTO();
		sellerDealsDTO.getSellerDeals().addAll(sellerDealService.getHotDeals());
		System.out.println("list of seller deals "
				+ sellerDealsDTO.getSellerDeals().size());
		return Response.ok().entity(sellerDealsDTO).build();
	}

	@Path("/buyers/{id}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response show(@PathParam("id") Integer id) {
		SellerDealsDTO sellerDealsDTO = new SellerDealsDTO();
		sellerDealsDTO.getSellerDeals().addAll(
				sellerDealService.getBuyerHotDeals(id));
		System.out.println("list of seller deals "
				+ sellerDealsDTO.getSellerDeals().size());
		return Response.ok().entity(sellerDealsDTO).build();
	}

	@Path("/")
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_JSON })
	public Response create(SellerDealsDTO sellerDealsDTO) {
		System.out.println("sellerDeal " + sellerDealsDTO);
		ResponseBuilder response;
		String message = "SellerDeal Successfully created";
		try {
			sellerDealService.createSellerDeals(sellerDealsDTO);
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
	public Response update(@PathParam("id") int id, SellerDealDTO sellerDealDTO) {
		System.out.println("sellerDeal " + sellerDealDTO);
		ResponseBuilder response;
		try {
			sellerDealService.updateSellerDeal(sellerDealDTO);
			response = Response.ok(sellerDealDTO);
		} catch (Exception e) {
			String message = e.getMessage();
			response = Response.status(Response.Status.BAD_REQUEST)
					.type(MediaType.TEXT_PLAIN).entity(message);
		}
		return response.build();
	}

}
