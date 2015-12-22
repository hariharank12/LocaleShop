/**
 * 
 */
package com.org.doorstep.dao;

import java.util.List;

import com.org.doorstep.entity.Seller;
import com.org.doorstep.entity.SellerBranch;

/**
 * @author hariharank12
 *
 */
public interface SellerDAO {

	public Seller getSeller(int id);

	public List<Seller> getSellers();

	public void createSeller(Seller s);

	public Seller updateSeller(Seller s);

	SellerBranch updateSellerBranch(SellerBranch sellerBranch);

	public void createSellerBranch(SellerBranch s);

}
