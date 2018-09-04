package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cg.bean.Product;
/*
 * author name= Akshay
 * Interface Name=IProductRepo
 * date of creation = 08/08/2018
 */

@Repository
public interface IProductRepo extends JpaRepository<Product, String>{

	
	@Query("SELECT a FROM Product a where a.id= :id") 
	Product getProductDetails(@Param("id") String id);
	
	
}
