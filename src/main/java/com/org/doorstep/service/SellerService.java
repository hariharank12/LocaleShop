/**
 * 
 */
package com.org.doorstep.service;

import java.util.List;

import com.org.doorstep.dto.SellerDTO;

/**
 * @author hariharank12
 *
 */
public interface SellerService {

	public SellerDTO getSeller(int sellerId);

	public List<SellerDTO> getAllSellers();

	SellerDTO updateSeller(int sellerId, SellerDTO sellerDTO);

	void createSeller(SellerDTO sellerDTO);

}
