/**
 * 
 */
package com.org.doorstep.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.doorstep.dao.SellerDAO;
import com.org.doorstep.entity.Seller;
import com.org.doorstep.entity.SellerBranch;

/**
 * @author hariharank12
 *
 */
@Repository
public class SellerDAOImpl implements SellerDAO {

	@PersistenceContext
	EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tutorials.dao.SellerDAO#getSellers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Seller> getSellers() {
		List<Seller> sellers = null;
		try {
			Query query = em.createQuery("SELECT s FROM Seller s");

			sellers = query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return sellers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tutorials.dao.SellerDAO#getSeller(int)
	 */
	@Override
	public Seller getSeller(int id) {
		Seller Seller = em.find(Seller.class, id);
		System.out.println("Seller record is " + Seller);
		System.out.println("Seller record name is " + Seller.getName());
		return Seller;
	}

	@Override
	public void createSeller(Seller s) {
		try {
			em.persist(s);
			em.flush();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
	}

	@Override
	public void createSellerBranch(SellerBranch s) {
		try {
			em.persist(s);
			em.flush();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Seller updateSeller(Seller s) {
		Seller updatedSeller = null;
		try {

			updatedSeller = em.merge(s);
			em.flush();
			System.out.println("seller update dao");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
		return updatedSeller;
	}

	@Override
	public SellerBranch updateSellerBranch(SellerBranch sellerBranch) {
		SellerBranch updatedSeller = null;
		try {

			updatedSeller = em.merge(sellerBranch);
			em.flush();
			System.out.println("seller update dao");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
		return updatedSeller;
	}

}
