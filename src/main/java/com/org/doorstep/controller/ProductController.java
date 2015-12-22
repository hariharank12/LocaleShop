/**
 * 
 */
package com.org.doorstep.controller;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import com.org.doorstep.dto.ProductDTO;
import com.org.doorstep.dto.ProductsDTO;
import com.org.doorstep.service.ProductService;

/**
 * @author hariharank12
 *
 */
@Controller
@Singleton
@Path("/products")
public class ProductController {

	@Autowired
	ProductService productService;

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
		ProductDTO productDTO = productService.getProduct(Integer.parseInt(id));
		return Response.ok().entity(productDTO).build();
	}

	// @Path("/")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response index() {
		ProductsDTO productsDTO = new ProductsDTO();
		productsDTO.getProducts().addAll(productService.getAllProducts());
		System.out.println("list of products "
				+ productsDTO.getProducts().size());
		return Response.ok().entity(productsDTO).build();
	}

}
