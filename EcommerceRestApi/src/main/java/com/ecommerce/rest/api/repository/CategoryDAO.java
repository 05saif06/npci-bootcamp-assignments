package com.ecommerce.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.rest.api.entity.Category;
@RepositoryRestResource(path="category")
@CrossOrigin("http://localhost:4200/")
public interface CategoryDAO extends JpaRepository<Category,Integer>{

}
