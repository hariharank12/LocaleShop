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

/**
 * @author hariharank12
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "sellerdeals" })
@XmlRootElement(name = "sellerdeals")
public class SellerDealsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "sellerdeal", required = true)
	// @JsonProperty("sellerdealsty")
	protected List<SellerDealDTO> sellerdeals;

	public List<SellerDealDTO> getSellerDeals() {
		if (sellerdeals == null) {
			sellerdeals = new ArrayList<SellerDealDTO>();
		}
		return this.sellerdeals;
	}

	public void setSellerDeals(List<SellerDealDTO> sellerDealDTOs) {
		this.sellerdeals = sellerDealDTOs;
	}

}
