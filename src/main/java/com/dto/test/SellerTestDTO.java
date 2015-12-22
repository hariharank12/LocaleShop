/**
 * 
 */
package com.dto.test;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.dozer.Mapping;

/**
 * @author hariharank12
 *
 */

@XmlRootElement(name = "seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerTestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@XmlElement(required = true)
	private Integer id;

	@Mapping("name")
	@XmlElement(required = true)
	private String name;

	@XmlElement(required = true)
	private String description;

	@XmlElement(required = true)
	private String location;

	/*
	 * @XmlElement(name = "branches", required = true)
	 * 
	 * @JsonProperty("sellerBranches")
	 * 
	 * @Mapping("sellerBranches") private List<SellerBranchesTestDTO>
	 * sellerBranches;
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// @XmlElement(name = "sellerId", nillable = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public List<SellerBranchesTestDTO> getSellerBranches() { return
	 * sellerBranches; }
	 * 
	 * public void setSellerBranches(List<SellerBranchesTestDTO> sellerBranches)
	 * { this.sellerBranches = sellerBranches; }
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
