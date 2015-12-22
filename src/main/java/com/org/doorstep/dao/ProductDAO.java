package com.org.doorstep.dao;

import java.util.List;

import com.org.doorstep.entity.Product;

public interface ProductDAO {

	public Product getProduct(int id);

	public List<Product> getProducts();

	public void createProduct(Product s);

	public Product updateProduct(Product s);

}
