package com.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.dto.ProductPriceUpdate;
import com.app.pojo.Product;
import com.app.service.ProductService;



@RestController
@RequestMapping("/product")
@Validated
public class ProductController {
	@Autowired
	private ProductService productservice;
	
	public ProductController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctor of "+getClass());
	}
	@GetMapping
	public List<Product> getAllProduct(){
		return productservice.getAllProducts(); 
	}
	@PostMapping("/category/{categoryId}")
	public ProductDTO addNewProduct(@RequestBody @Valid ProductDTO product,@PathVariable @NotNull Long categoryId) {
		return productservice.addNewProduct(product,categoryId);
			}
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productservice.getProductById(id);
	}
	@GetMapping("/category/{category}")
	public List<ProductDTO> getProductByCategory(@PathVariable String category){
		return productservice.getProductsByCategory(category);
	}
	@DeleteMapping("/{id}")
	public ApiResponse deleteProductById(@PathVariable Long id) {
		return productservice.deleteProductById(id);
		
	}
	//URL http://host:port/ctx_path/productId
	@PutMapping
	public ProductPriceUpdate updateProduct(@RequestBody ProductPriceUpdate product) {
		return productservice.updateProduct(product);
	} 
}
