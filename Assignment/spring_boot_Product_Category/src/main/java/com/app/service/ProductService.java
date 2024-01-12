package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.dto.ProductPriceUpdate;
import com.app.pojo.Product;

public interface ProductService {

	List<Product> getAllProducts();

	ProductDTO addNewProduct(ProductDTO product, Long categoryId);

	Product getProductById(Long id);

	

	ApiResponse deleteProductById(Long id);

	ProductPriceUpdate updateProduct(ProductPriceUpdate product);

	List<ProductDTO> getProductsByCategory(String category);


	
}
