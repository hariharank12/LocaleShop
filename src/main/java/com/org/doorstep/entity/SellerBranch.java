package com.org.doorstep.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the seller_branches database table.
 * 
 */
@Entity
@Table(name = "seller_branches")
@NamedQuery(name = "SellerBranch.findAll", query = "SELECT s FROM SellerBranch s")
public class SellerBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "branch_city")
	private String branchCity;

	@Column(name = "branch_locality")
	private String branchLocality;

	@Column(name = "branch_town")
	private String branchTown;

	private String description;

	// @Type(type = "org.hibernate.spatial.GeometryType")
	// private com.vividsolutions.jts.geom.Point locality;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "latitude", column = @Column(name = "latitude")),
			@AttributeOverride(name = "longitude", column = @Column(name = "longitude")) })
	private Point point;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date modifiedDate;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	private String name;

	// bi-directional many-to-one association to Seller
	@ManyToOne
	private Seller seller;

	public SellerBranch() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranchCity() {
		return this.branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public String getBranchLocality() {
		return this.branchLocality;
	}

	public void setBranchLocality(String branchLocality) {
		this.branchLocality = branchLocality;
	}

	public String getBranchTown() {
		return this.branchTown;
	}

	public void setBranchTown(String branchTown) {
		this.branchTown = branchTown;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public com.vividsolutions.jts.geom.Point getLocality() { return
	 * this.locality; }
	 * 
	 * public void setLocality(com.vividsolutions.jts.geom.Point locality) {
	 * this.locality = locality; }
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
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