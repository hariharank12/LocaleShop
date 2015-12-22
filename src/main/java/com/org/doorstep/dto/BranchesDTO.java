package com.org.doorstep.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.dozer.Mapping;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "sellerBranches" })
@XmlRootElement(name = "selBranches")
public class BranchesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "jbranches", required = true)
	@JsonProperty("selJBranches")
	@Mapping("sellerBranches")
	private List<SellerBranchesDTO> sellerBranches;

	public List<SellerBranchesDTO> getSellerBranches() {
		return sellerBranches;
	}

	public void setSellerBranches(List<SellerBranchesDTO> sellerBranches) {
		this.sellerBranches = sellerBranches;
	}

}
