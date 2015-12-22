/**
 * 
 */
package com.dto.test;

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
@XmlType(name = "", propOrder = { "sellers" })
@XmlRootElement(name = "sellers")
public class SellersTestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "seller", required = true)
	@JsonProperty("sellers")
	protected List<SellerTestDTO> sellers;

	public List<SellerTestDTO> getSellers() {
		if (sellers == null) {
			sellers = new ArrayList<SellerTestDTO>();
		}
		return this.sellers;
	}

	public void setSellers(List<SellerTestDTO> SellerDTOs) {
		this.sellers = SellerDTOs;
	}

}
