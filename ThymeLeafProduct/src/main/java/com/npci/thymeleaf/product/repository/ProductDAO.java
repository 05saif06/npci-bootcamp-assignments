package com.npci.thymeleaf.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.npci.thymeleaf.product.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

	public List<Product> findByProductNameContainsAllIgnoreCase(String productName);

	@Query(value = "select * from Product where categoryid=:(select categoryid from ProductCategory where categoryname=:categoryname)", nativeQuery = true)
	public List<Product> findByCategoryNameContainsAllIgnoreCase(@Param("categoryName") String categoryName);

}
