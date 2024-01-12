package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Category;

public interface CategoryDao extends JpaRepository<Category,Long> {

	Category findByName(String category);

}
