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
@XmlType(name = "", propOrder = { "sellers" })
@XmlRootElement(name = "sellers")
public class SellersDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "sellers", required = true)
	@JsonProperty("sellers")
	protected List<SellerDTO> sellers;

	public List<SellerDTO> getSellers() {
		if (sellers == null) {
			sellers = new ArrayList<SellerDTO>();
		}
		return this.sellers;
	}

	public void setSellers(List<SellerDTO> SellerDTOs) {
		this.sellers = SellerDTOs;
	}

}
