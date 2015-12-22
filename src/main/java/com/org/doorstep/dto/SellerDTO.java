/**
 * 
 */
package com.org.doorstep.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.dozer.Mapping;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author hariharank12
 *
 */

@XmlRootElement(name = "seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SellerDTO() {
		// this.branches = new BranchesDTO();
		// branches.getSellerBranches() = this.sellerBranches;
		// branches.setSellerBranches(getSellerBranches());
	}

	@Mapping("id")
	@XmlElement(name = "sellerId", nillable = true)
	private Integer id;

	@Mapping("name")
	@XmlElement(required = true)
	private String name;

	@XmlElement(required = true)
	private String description;

	@XmlElement(required = true)
	private String location;

	@XmlElement(name = "branches", required = true)
	@JsonProperty("sellerBranches")
	private List<SellerBranchesDTO> sellerBranches;

	// @XmlElement(name = "brches", required = true)
	// @JsonProperty("selBrches")
	// @Mapping("this.sellerBranches")
	// private BranchesDTO branches;

	@XmlElement(required = true)
	@Mapping("createdDate")
	@JsonProperty("createdDate")
	private java.util.Date createdDate;

	@XmlElement(required = true)
	@Mapping("modifiedDate")
	@JsonProperty("modifiedDate")
	private java.util.Date modifiedDate;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public List<SellerBranchesDTO> getSellerBranches() {
		return sellerBranches;
	}

	@Mapping("sellerBranches")
	public void setSellerBranches(List<SellerBranchesDTO> sellerBranches) {
		System.out.println("iam clalled");
		this.sellerBranches = sellerBranches;
		// this.branches.setSellerBranches(getSellerBranches());
	}

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

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	public java.util.Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
