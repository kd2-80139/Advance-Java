package com.app.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom.NahiMila;
import com.app.dao.CategoryDao;
import com.app.dao.ProductDao;
import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.dto.ProductPriceUpdate;
import com.app.pojo.Category;
import com.app.pojo.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productdao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CategoryDao categorydao;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		return productdao.findAll();
	}
	@Override
	public ProductDTO addNewProduct(ProductDTO product, Long categoryId) {
		// TODO Auto-generated method stub
		Category c=categorydao.findById(categoryId).orElseThrow();
		Product p=mapper.map(product, Product.class);
			p.setCategory(c);
		 p=productdao.save(p);
		
		 
		return mapper.map(p,ProductDTO.class);
		
	}
	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productdao.findById(id).orElseThrow(()->{
			throw new NahiMila("Essa Product Nhi Humare pass");});
	}
	@Override
	public List<ProductDTO> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		Category c=categorydao.findByName(category);
		List<ProductDTO> list= productdao.findByCategory(c).stream()
		.map(prod->mapper.map(prod, ProductDTO.class)).collect(Collectors.toList());
		list.forEach(p->p.setCategotyName(category));
		return list;
	}
	@Override
	public ApiResponse deleteProductById(Long id) {
		// TODO Auto-generated method stub
		if(productdao.existsById(id)) {
		productdao.deleteById(id);
		return new ApiResponse("Deleted "+id);
		}
		return new ApiResponse("Not Deleted "+id);
	}
	@Override
	public ProductPriceUpdate updateProduct(ProductPriceUpdate product) {
		// TODO Auto-generated method stub
		Product p=productdao.findById(product.getId()).orElseThrow();
		p.setPrice(product.getPrice());
		productdao.save(p);
		return mapper.map(p, ProductPriceUpdate.class);
	}
	

}
