/**
 * 
 */
package com.org.doorstep.dto;

import java.io.Serializable;
import java.util.Date;

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
@XmlRootElement(name = "sellerdeal")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerDealDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@XmlElement(name = "dealId", nillable = true)
	private int id;

	private Date dateFrom;

	private Date dateTo;

	private double dealPrice;

	private byte homeDelivery;

	private double price;

	@Mapping("sellerBranch")
	@XmlElement(name = "sellerBranch", required = true)
	@JsonProperty("sellerBranch")
	private SellerBranchesDTO sellerBranch;

	private int totalUnits;

	private String unitName;

	@Mapping("product")
	@XmlElement(name = "product", required = true)
	@JsonProperty("product")
	private ProductDTO product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public double getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public byte getHomeDelivery() {
		return homeDelivery;
	}

	public void setHomeDelivery(byte homeDelivery) {
		this.homeDelivery = homeDelivery;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public SellerBranchesDTO getSellerBranch() {
		return sellerBranch;
	}

	public void setSellerBranch(SellerBranchesDTO sellerBranch) {
		this.sellerBranch = sellerBranch;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
