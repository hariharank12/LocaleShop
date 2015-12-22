/**
 * 
 */
package com.org.doorstep.daoimpl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.doorstep.dao.DealsSellerDAO;
import com.org.doorstep.entity.DealsSeller;

/**
 * @author hariharank12
 *
 */
@Repository
public class DealsSellerDAOImpl implements DealsSellerDAO {

	@PersistenceContext
	EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.dao.DealsSellerDAO#getAllDeals()
	 */
	@Override
	public List<DealsSeller> getAllDeals() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.dao.DealsSellerDAO#getHotDeals()
	 */
	@Override
	public List<DealsSeller> getHotDeals() {
		List<DealsSeller> sellerDeals = null;
		Date presentDate = Calendar.getInstance().getTime();

		Query query = em.createQuery("SELECT d FROM DealsSeller d "
				+ "where :presentDate BETWEEN d.dateFrom AND d.dateTo");
		query.setParameter("presentDate", presentDate);
		sellerDeals = query.getResultList();
		return sellerDeals;
	}

	@Override
	public List<DealsSeller> getBuyerDeals(BigDecimal latitude,
			BigDecimal longitude) {
		List<DealsSeller> sellerDeals = null;
		Date presentDate = Calendar.getInstance().getTime();
		BigDecimal maxLatitude = latitude.add(new BigDecimal(15.00));
		BigDecimal minLatitude = latitude.subtract(new BigDecimal(15.00));
		BigDecimal maxLongitude = longitude.add(new BigDecimal(20.00));
		BigDecimal minLongitude = longitude.subtract(new BigDecimal(20.00));

		Query query = em
				.createQuery("SELECT d FROM DealsSeller d INNER JOIN FETCH d.sellerBranch sb "
						+ "where (:presentDate BETWEEN d.dateFrom AND d.dateTo) "
						+ "AND (sb.point.latitude BETWEEN :minLatitude AND :maxLatitude) "
						+ "AND (sb.point.longitude BETWEEN :minLongitude AND :maxLongitude)");
		query.setParameter("presentDate", presentDate);
		query.setParameter("minLatitude", minLatitude);
		query.setParameter("maxLatitude", maxLatitude);
		query.setParameter("minLongitude", minLongitude);
		query.setParameter("maxLongitude", maxLongitude);
		sellerDeals = query.getResultList();
		return sellerDeals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.dao.DealsSellerDAO#createDeal(com.org.doorstep.entity
	 * .DealsSeller)
	 */
	@Override
	public void createDeal(DealsSeller s) {
		try {
			em.persist(s);
			em.flush();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.dao.DealsSellerDAO#updateDeal(com.org.doorstep.entity
	 * .DealsSeller)
	 */
	@Override
	public DealsSeller updateDeal(DealsSeller s) {
		DealsSeller dealsSeller = null;
		try {

			dealsSeller = em.merge(s);
			em.flush();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
		return dealsSeller;
	}

}
