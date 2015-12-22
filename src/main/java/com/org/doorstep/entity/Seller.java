package com.org.doorstep.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the sellers database table.
 * 
 */
@Entity
@Table(name = "sellers")
@NamedQuery(name = "Seller.findAll", query = "SELECT s FROM Seller s")
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String location;

	private String name;

	// bi-directional many-to-one association to SellerBranch
	@OneToMany(mappedBy = "seller", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<SellerBranch> sellerBranches;

	@Temporal(TemporalType.TIMESTAMP)
	// mappedBy
	private java.util.Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	// mappedBy
	private java.util.Date modifiedDate;

	public Seller() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SellerBranch> getSellerBranches() {
		return this.sellerBranches;
	}

	public void setSellerBranches(List<SellerBranch> sellerBranches) {
		this.sellerBranches = sellerBranches;
	}

	public SellerBranch addSellerBranch(SellerBranch sellerBranch) {
		getSellerBranches().add(sellerBranch);
		sellerBranch.setSeller(this);

		return sellerBranch;
	}

	public SellerBranch removeSellerBranch(SellerBranch sellerBranch) {
		getSellerBranches().remove(sellerBranch);
		sellerBranch.setSeller(null);

		return sellerBranch;
	}

	public SellerBranch getSellerBranchBySequenceId(Integer id) {
		for (SellerBranch sellerBranch : getSellerBranches())
			if (sellerBranch.getId().equals(id))
				return sellerBranch;
		return null;
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