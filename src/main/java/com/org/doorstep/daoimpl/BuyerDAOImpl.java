/**
 * 
 */
package com.org.doorstep.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.doorstep.entity.Buyer;

/**
 * @author hariharank12
 *
 */
@Repository
public class BuyerDAOImpl {

	@PersistenceContext
	EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tutorials.dao.BuyerDAO#getBuyers()
	 */
	@SuppressWarnings("unchecked")
	public List<Buyer> getBuyers() {
		List<Buyer> buyers = null;
		try {
			Query query = em.createQuery("SELECT s FROM Buyer s");

			buyers = query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return buyers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tutorials.dao.BuyerDAO#getBuyer(int)
	 */

	public Buyer getBuyer(int id) {
		Buyer Buyer = em.find(Buyer.class, id);
		System.out.println("Buyer record is " + Buyer);
		System.out.println("Buyer record name is " + Buyer.getName());
		return Buyer;
	}

	public void createBuyer(Buyer s) {
		try {
			em.persist(s);
			em.flush();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
	}

	public Buyer updateBuyer(Buyer s) {
		Buyer updatedBuyer = null;
		try {

			updatedBuyer = em.merge(s);
			em.flush();
			System.out.println("buyer update dao");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
		return updatedBuyer;
	}

}
