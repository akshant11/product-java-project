package com.product.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.demo.entity.Product;
import com.product.demo.request.ProductDto;

public interface ProductServiceIntr {

	ProductDto createProduct(ProductDto productDto);

	ResponseEntity<List<Product>> getMaxSoldProduct();

	boolean isExist(ProductDto productDto);

	ResponseEntity<Product> updateProduct(ProductDto productDto);

	ResponseEntity<List<Product>> getAllProducts();

	ResponseEntity<String> deleteProductById(Long productId);

	ResponseEntity<Product> getByProductName(String productName);

}
