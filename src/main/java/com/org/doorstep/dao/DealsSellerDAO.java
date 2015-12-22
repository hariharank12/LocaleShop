/**
 * 
 */
package com.org.doorstep.dao;

import java.math.BigDecimal;
import java.util.List;

import com.org.doorstep.entity.DealsSeller;

/**
 * @author hariharank12
 *
 */
public interface DealsSellerDAO {

	public List<DealsSeller> getAllDeals();

	public List<DealsSeller> getHotDeals();

	public void createDeal(DealsSeller s);

	public DealsSeller updateDeal(DealsSeller s);

	/**
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	List<DealsSeller> getBuyerDeals(BigDecimal latitude, BigDecimal longitude);

}
