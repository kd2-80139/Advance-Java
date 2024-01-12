package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojo.Category;
import com.app.pojo.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	List<Product> findByCategory(Category category);

}
