/**
 * 
 */
package com.org.doorstep.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hariharank12
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "products" })
@XmlRootElement(name = "products")
public class ProductsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "products", required = true)
	@JsonProperty("products")
	protected List<ProductDTO> products;

	public List<ProductDTO> getProducts() {
		if (products == null) {
			products = new ArrayList<ProductDTO>();
		}
		return this.products;
	}

	public void setProducts(List<ProductDTO> ProductDTOs) {
		this.products = ProductDTOs;
	}

}
