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

import com.org.doorstep.dto.SellerDTO;
import com.org.doorstep.dto.SellersDTO;
import com.org.doorstep.service.SellerService;

/**
 * @author hariharank12
 *
 */
@Controller
@Singleton
@Path("/sellers")
public class SellerController {

	@Autowired
	SellerService sellerService;

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
		SellerDTO sellerDTO = sellerService.getSeller(Integer.parseInt(id));
		return Response.ok().entity(sellerDTO).build();
	}

	@Path("/")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response index() {
		SellersDTO sellersDTO = new SellersDTO();
		sellersDTO.getSellers().addAll(sellerService.getAllSellers());
		System.out.println("list of sellers " + sellersDTO.getSellers().size());
		// jaxb.
		/*
		 * try { JAXBContext context =
		 * JAXBContext.newInstance(SellersDTO.class); Marshaller m =
		 * context.createMarshaller();
		 * m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 * m.marshal(sellersDTO, System.out); } catch (JAXBException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		return Response.ok().entity(sellersDTO).build();
	}

	@Path("/")
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML,
			MediaType.APPLICATION_JSON })
	public Response create(SellerDTO sellerDTO) {
		System.out.println("seller " + sellerDTO.getName());
		ResponseBuilder response;
		String message = "Seller Successfully created";
		try {
			sellerService.createSeller(sellerDTO);
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
	public Response update(@PathParam("id") int id, SellerDTO sellerDTO) {
		System.out.println("seller " + sellerDTO.getName());
		System.out.println("seller "
				+ sellerDTO.getSellerBranches().get(0).getLatitude());
		String message = StringUtils.EMPTY;
		ResponseBuilder response;
		try {
			SellerDTO seller = sellerService.updateSeller(id, sellerDTO);
			// response = Response.ok(seller, MediaType.APPLICATION_JSON);
			response = Response.ok(seller);
		} catch (Exception e) {
			message = e.getMessage();
			response = Response.status(Response.Status.BAD_REQUEST)
					.type(MediaType.TEXT_PLAIN).entity(message);
		}
		return response.build();
	}

}
