/**
 * 
 */
package com.org.doorstep.service;

import java.util.List;

import com.org.doorstep.dto.BuyerDTO;

/**
 * @author hariharank12
 *
 */
public interface BuyerService {

	public BuyerDTO getBuyer(int buyerId);

	public List<BuyerDTO> getAllBuyers();

	BuyerDTO updateBuyer(int buyerId, BuyerDTO buyerDTO);

	void createBuyer(BuyerDTO buyerDTO);

}
