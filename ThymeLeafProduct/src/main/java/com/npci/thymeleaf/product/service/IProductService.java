package com.npci.thymeleaf.product.service;

import java.util.List;

import com.npci.thymeleaf.product.entity.Product;
import com.npci.thymeleaf.product.entity.ProductCategory;

public interface IProductService {
	
	public List<Product> findAllProduct();

	public abstract void saveProductDetails(Product product);

	public Product findById(int productId);

	public void deleteById(int productId);
	
	public List<Product> searchBy(String productName);
	
	public List<Product> searchByCategory(String CategoryName);
	


}
