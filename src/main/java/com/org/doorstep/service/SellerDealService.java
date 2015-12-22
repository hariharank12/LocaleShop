/**
 * 
 */
package com.org.doorstep.service;

import java.util.List;

import com.org.doorstep.dto.SellerDealDTO;
import com.org.doorstep.dto.SellerDealsDTO;

/**
 * @author hariharank12
 *
 */
public interface SellerDealService {

	public List<SellerDealDTO> getHotDeals();

	/**
	 * @param buyerId
	 * @return
	 */
	List<SellerDealDTO> getBuyerHotDeals(Integer buyerId);

	/**
	 * @param sellerDealDTO
	 */
	public void createSellerDeal(SellerDealDTO sellerDealDTO);

	/**
	 * @param sellerDealDTOs
	 */
	void createSellerDeals(SellerDealsDTO sellerDealDTOs);

	/**
	 * @param sellerDealDTO
	 * @return
	 */
	SellerDealDTO updateSellerDeal(SellerDealDTO sellerDealDTO);
}
