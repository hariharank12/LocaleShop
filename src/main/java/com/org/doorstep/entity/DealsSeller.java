package com.org.doorstep.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the deals_sellers database table. SELECT * FROM
 * `deals_sellers` WHERE `date_from` = '2015-12-13 06:05:00'
 */
@Entity
@Table(name = "deals_sellers")
@NamedQuery(name = "DealsSeller.findAll", query = "SELECT d FROM DealsSeller d")
public class DealsSeller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_from")
	private Date dateFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_to")
	private Date dateTo;

	@Column(name = "deal_price")
	private double dealPrice;

	@Column(name = "home_delivery")
	private byte homeDelivery;

	private double price;

	// @Column(name="seller_branch_id")
	// private int sellerBranchId;

	// bi-directional many-to-one association to Seller
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "seller_branch_id", nullable = false)
	private SellerBranch sellerBranch;

	@Column(name = "total_units")
	private int totalUnits;

	@Column(name = "unit_name")
	private String unitName;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	private Product product;

	public DealsSeller() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public SellerBranch getSellerBranch() {
		if (this.sellerBranch == null)
			this.sellerBranch = new SellerBranch();
		return sellerBranch;
	}

	public void setSellerBranch(SellerBranch sellerBranch) {
		this.sellerBranch = sellerBranch;
	}

	public double getDealPrice() {
		return this.dealPrice;
	}

	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public byte getHomeDelivery() {
		return this.homeDelivery;
	}

	public void setHomeDelivery(byte homeDelivery) {
		this.homeDelivery = homeDelivery;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalUnits() {
		return this.totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Product getProduct() {
		if (this.product == null)
			this.product = new Product();
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}