package com.cg.service;

import java.util.List;

import com.cg.bean.Product;
import com.cg.exception.ProductException;

public interface IProductService {
	
	
	Product createProduct(Product product) throws ProductException;
	Product updateProduct(Product product) throws ProductException;
	String deleteProduct(String id) throws ProductException;
	List<Product> viewProduct() throws ProductException;
	Product findProductbyId(String id) throws ProductException;
	Product acceptProductDetails(Product product);
	
	
	

}
