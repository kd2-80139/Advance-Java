package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CategoryDao;
import com.app.dto.CategoryDTO;
import com.app.pojo.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public CategoryDTO addNewCategory(CategoryDTO cat) {
		// TODO Auto-generated method stub
		Category c=categoryDao.save(mapper.map(cat, Category.class));
		
		return mapper.map(c, CategoryDTO.class);
	}
}
