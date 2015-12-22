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
@XmlType(name = "", propOrder = { "buyers" })
@XmlRootElement(name = "buyers")
public class BuyersDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "buyers", required = true)
	// @JsonProperty("buyersty")
	protected List<BuyerDTO> buyers;

	public List<BuyerDTO> getBuyers() {
		if (buyers == null) {
			buyers = new ArrayList<BuyerDTO>();
		}
		return this.buyers;
	}

	public void setBuyers(List<BuyerDTO> buyerDTOs) {
		this.buyers = buyerDTOs;
	}

}
