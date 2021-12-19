package com.product.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.demo.entity.Product;
import com.product.demo.request.ProductRequest;

public interface ProductServiceIntr {

	Product createProduct(ProductRequest productRequest);

	ResponseEntity<List<Product>> getMaxSoldProduct();

	boolean isExist(ProductRequest productRequest);

//	ResponseEntity<Product> updateProduct(ProductRequest productRequest);
//
//	ResponseEntity<List<Product>> getAllProducts();
//
//	ResponseEntity<String> deleteProductById(Long productId);
//
//	ResponseEntity<List<Product>> getByProductName(String productName);

}
