package com.org.doorstep.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name = "products")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	// bi-directional many-to-one association to DealsSeller
	// @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade =
	// CascadeType.ALL)
	// private List<DealsSeller> dealsSellers;

	public Product() {
	}

	public int getId() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DealsSeller> getDealsSellers() {
		return null;
		// return this.dealsSellers;
	}

	public void setDealsSellers(List<DealsSeller> dealsSellers) {
		// this.dealsSellers = dealsSellers;
	}

	public DealsSeller addDealsSeller(DealsSeller dealsSeller) {
		getDealsSellers().add(dealsSeller);
		dealsSeller.setProduct(this);

		return dealsSeller;
	}

	public DealsSeller removeDealsSeller(DealsSeller dealsSeller) {
		getDealsSellers().remove(dealsSeller);
		dealsSeller.setProduct(null);

		return dealsSeller;
	}

}