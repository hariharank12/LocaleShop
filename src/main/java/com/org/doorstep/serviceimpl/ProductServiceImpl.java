/**
 * 
 */
package com.org.doorstep.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.doorstep.dao.ProductDAO;
import com.org.doorstep.dto.ProductDTO;
import com.org.doorstep.entity.Product;
import com.org.doorstep.helper.JerseyDozerMapper;
import com.org.doorstep.service.ProductService;

/**
 * @author hariharank12
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO ProductDAO;

	@Autowired
	private JerseyDozerMapper<Product, ProductDTO> mapper;

	@Autowired
	private JerseyDozerMapper<ProductDTO, Product> fwdMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.service.ProductService#getProduct(int)
	 */
	@Override
	public ProductDTO getProduct(int ProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.service.ProductService#getAllProducts()
	 */
	@Override
	public List<ProductDTO> getAllProducts() {
		System.out
				.println("Products branch points " + ProductDAO.getProducts());

		return mapper.mapList(ProductDAO.getProducts(), ProductDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.service.ProductService#updateProduct(int,
	 * com.org.doorstep.dto.ProductDTO)
	 */
	@Override
	public ProductDTO updateProduct(int ProductId, ProductDTO ProductDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.service.ProductService#createProduct(com.org.doorstep
	 * .dto.ProductDTO)
	 */
	@Override
	public void createProduct(ProductDTO ProductDTO) {
		// TODO Auto-generated method stub

	}

}
