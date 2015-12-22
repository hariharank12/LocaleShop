/**
 * 
 */
package com.org.doorstep.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.doorstep.dao.ProductDAO;
import com.org.doorstep.entity.Product;

/**
 * @author hariharank12
 *
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.dao.ProductDAO#getProduct(int)
	 */
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.dao.ProductDAO#getProducts()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		Query query = em.createQuery("SELECT p FROM Product p");
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.dao.ProductDAO#createProduct(com.org.doorstep.entity
	 * .Product)
	 */
	@Override
	public void createProduct(Product s) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.dao.ProductDAO#updateProduct(com.org.doorstep.entity
	 * .Product)
	 */
	@Override
	public Product updateProduct(Product s) {
		// TODO Auto-generated method stub
		return null;
	}

}
