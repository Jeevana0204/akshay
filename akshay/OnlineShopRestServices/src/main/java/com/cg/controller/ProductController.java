package com.cg.controller;


/*
 * author name= Akshay  
 * Class Name=Product Controller
 * Number of Methods=5
 * Name of methods=  createproduct()
 *                   updateProduct()
 *                   deleteProduct()
 *                   viewProduct()
 *                   findProduct()
 *date of creation = 08/08/2018
 * 
 */
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Product;
import com.cg.exception.ProductException;
import com.cg.service.IProductService;

@RestController
public class ProductController {
@Autowired
	private IProductService service;
@RequestMapping(value="/addProduct",method=RequestMethod.POST)
public Product createproduct(@RequestBody Product product) throws ProductException {
	
	try {
		service.createProduct(product);
	} catch (ProductException e) {
		// TODO Auto-generated catch block
		throw new ProductException(e.getMessage());
	}
	return product;
}


@RequestMapping(value="/deleteProduct",method=RequestMethod.DELETE)
public String deleteProduct(String id) {
	
	try {
		service.deleteProduct(id);
	} catch (ProductException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return id+" is deleted";
	
}

@RequestMapping(value="/vewProduct",method=RequestMethod.GET)
public List<Product> viewProduct(){
	List<Product> pro=null;
	try {
		pro=service.viewProduct();
	} catch (ProductException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return pro;
	
}

@RequestMapping(value="/findProductById",method=RequestMethod.GET)
public Product findProduct(String id) {
	
	Product pro=null;
			try {
				pro=service.findProductbyId(id);
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return pro;
	
}


@RequestMapping(value="/updateProduct",method=RequestMethod.PUT)
public Product updateProduct(@RequestBody Product product) throws ProductException {
	Product pro=null;
	try {
		pro=service.updateProduct(product);
	} catch (ProductException e) {
		// TODO Auto-generated catch block
		throw new ProductException(e.getMessage());
	}
	
	return pro;
	
}

@RequestMapping(method=RequestMethod.GET,value= {"/sayHello"},produces= {"application/text"})
public ResponseEntity<String> getHelloMessage(){
	return new ResponseEntity<String>("Hello World From RestFulWebService",HttpStatus.OK);
}

@RequestMapping(value="/acceptProductDetails",method=RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public ResponseEntity<Product> acceptProductDetails(@ModelAttribute Product product){
	
	//onlineShopServices.acceptProductDetails(product);
	service.acceptProductDetails(product);
	return new ResponseEntity<>(product,HttpStatus.OK);
	
}

@RequestMapping(value="/viewProductById",method=RequestMethod.GET,produces= {"application/Json"})
public ResponseEntity<Product> getProductDetails(@PathParam(value="id")String id) throws ProductException{
	
	return new ResponseEntity<>(service.findProductbyId(id),HttpStatus.OK);
}

@RequestMapping(value="/viewAllProducts",method=RequestMethod.GET,produces= {"application/Json"})
public ResponseEntity<List> viewAllProducts() throws ProductException{
	return new ResponseEntity<>(service.viewProduct(),HttpStatus.OK);
	
}





	
}
