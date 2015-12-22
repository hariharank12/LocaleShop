/**
 * 
 */
package com.org.doorstep.service;

import java.util.List;

import com.org.doorstep.dto.ProductDTO;

/**
 * @author hariharank12
 *
 */
public interface ProductService {

	public ProductDTO getProduct(int ProductId);

	public List<ProductDTO> getAllProducts();

	ProductDTO updateProduct(int ProductId, ProductDTO ProductDTO);

	void createProduct(ProductDTO ProductDTO);

}
