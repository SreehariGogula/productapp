  package com.training.pms.galaxe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.galaxe.model.Product;
import com.training.pms.galaxe.productdao.ProductDAO;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String saveProduct(Product product) {
		String message =null;
		if(product.getPrice() <0 | product.getQuantityOnHand() < 0 )
		{
			message = "Product price or QOH cannot be negative. Not saved.";
		}
		else
		{
			message = "Product Saved successfully. You are genious";
			productDAO.save(product);

		}
		return message;
	}

	@Override
	public String updateProduct(Product product) {
		String message =null;
		if(product.getPrice() <0 | product.getQuantityOnHand() < 0 )
		{
			message = "Product price or QOH cannot be negative. Not Updated.";
		}
		else
		{
			message = "Product Updated successfully. You are genious";
			productDAO.save(product);

		}
		return message;
	}

	@Override
	public String deleteProduct(int productId) {
		productDAO.deleteById(productId);
		return "Product deleted successfully";
	}

	@Override
	public Product getProduct(int productId) {
		Optional<Product> product =  productDAO.findById(productId);
		return product.get();
	}

	@Override
	public List<Product> getProduct() {					//get all products
		System.out.println("getAllProducts method is called");
		return (List<Product>) productDAO.findAll();
	}

	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> product =  productDAO.findById(productId);
		return product.isPresent();
	}

	
	
	  @Override
		public List<Product> getProduct(String productName) {
			return productDAO.findByProductName(productName);
		}


		@Override
		public List<Product> getProduct(int min, int max) {
			// TODO Auto-generated method stub
			return productDAO.findByPriceBetween(min, max);
		}


		@Override
		public List<Product> searchProductByName(String productName) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String checkProductInventory(int productId, int quantityRequired) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Product> getProductByPrice(int price) {
			// TODO Auto-generated method stub
			return productDAO.findByPrice(price);
		}
}
