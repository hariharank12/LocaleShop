package com.org.doorstep.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.dozer.Mapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "branch")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerBranchesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@XmlElement(name = "branchId", nillable = true)
	private Integer branchId;

	// @XmlElement(name = "sellerId", nillable = true)
	private String branchCity;

	private String branchLocality;

	private String branchTown;

	private String description;

	private String name;

	@Mapping("point.latitude")
	private BigDecimal latitude;

	@Mapping("point.longitude")
	private BigDecimal longitude;

	@XmlElement(required = true)
	@Mapping("createdDate")
	@JsonProperty("createdDate")
	private java.util.Date createdDate;

	@XmlElement(required = true)
	@Mapping("modifiedDate")
	@JsonProperty("modifiedDate")
	private java.util.Date modifiedDate;

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Integer getId() {
		return branchId;
	}

	public void setId(Integer id) {
		this.branchId = id;
	}

	public String getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public String getBranchLocality() {
		return branchLocality;
	}

	public void setBranchLocality(String branchLocality) {
		this.branchLocality = branchLocality;
	}

	public String getBranchTown() {
		return branchTown;
	}

	public void setBranchTown(String branchTown) {
		this.branchTown = branchTown;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
