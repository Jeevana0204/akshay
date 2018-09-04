package com.cg.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.bean.Product;
import com.cg.dao.IProductRepo;

import com.cg.exception.ProductException;

/*
 * author name= Akshay
 * Class Name=ProductServiceImpl
 * Number of Methods=5
 * Name of methods=  createproduct()
 *                   updateProduct()
 *                   deleteProduct()
 *                   viewProduct()
 *                   findProduct()
 *date of creation = 08/08/2018
 * 
 */


@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
	private IProductRepo repo;
	@Override
	public Product createProduct(Product product) throws ProductException {
		boolean b=validatePro(product);
		if(b)
		repo.save(product);
		return product;
	}
	
	
	@Override
	public Product updateProduct(Product product) throws ProductException {

		boolean b=validatePro(product);
		if(b)
		repo.save(product);
		return product;
		/*Product pro=repo.getProductDetails(product.getId());
		String name=product.getName();
		String model=product.getModel();
		double price=product.getPrice();
		
		if((name!=null)&&(name!="")) {
			if(pro.getName().isEmpty())
				throw new ProductException("Name cannot be empty");
			pro.setName(name);
		}
		if(model!=null) {
			if(pro.getModel().isEmpty())
				throw new ProductException("Model name should not be empty");
			pro.setModel(model);
		}
		if(price!=0) {
			if(pro.getPrice()<=0)
				throw new ProductException("Price must be more than zero");	
			pro.setPrice(price);
		}
		
     repo.save(pro);
		return pro;*/
	}
	
	
	@Override
	public String deleteProduct(String id) throws ProductException {
		repo.deleteById(id);
		return id;
	}
	
	
	@Override
	public List<Product> viewProduct() throws ProductException {
		
		return repo.findAll();
	}
	
	
	@Override
	public Product findProductbyId(String id) throws ProductException {
		
		return repo.getProductDetails(id);
	}
	
	
	
	private boolean validatePro(Product pro) throws ProductException {
		if(pro.getId().isEmpty())
			throw new ProductException("id cannot be empty");
		if(pro.getPrice()<=0)
			throw new ProductException("Price must be more than zero");
		if(pro.getName().isEmpty())
			throw new ProductException("Name cannot be empty");
		if(!pro.getName().matches("[A-Za-z]{2,}"))
			throw new ProductException("Product Name must have only alphabets");
		if(pro.getDescription().isEmpty())
			throw new ProductException("Description should not be empty");
		
		return true;
	}


	@Override
	public Product acceptProductDetails(Product product) {
		repo.save(product);
		return product;
		
	}

}
