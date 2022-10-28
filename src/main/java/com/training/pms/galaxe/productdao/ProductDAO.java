package com.training.pms.galaxe.productdao;
 import com.training.pms.galaxe.model.Product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface ProductDAO extends CrudRepository<Product, Integer>{
	
	public List<Product> findByProductName(String productName);
	public List<Product> findByPrice(int price);	
	public List<Product> findByPriceBetween(int min,int max);

}
