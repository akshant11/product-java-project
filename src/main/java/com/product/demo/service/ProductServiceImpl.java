package com.product.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.demo.entity.Product;
import com.product.demo.repository.ProductRepository;
import com.product.demo.request.ProductRequest;

@Service
public class ProductServiceImpl implements ProductServiceIntr {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(ProductRequest productRequest) {

		ObjectMapper objectMapper = new ObjectMapper();
		Product product = objectMapper.convertValue(productRequest, Product.class);
		return productRepository.save(product);
	}

	@Override
	public ResponseEntity<List<Product>> getMaxSoldProduct() {

		List<Product> op = (List<Product>) productRepository.getByQuantitySold();
		if (!op.isEmpty()) {
			return ResponseEntity.ok(op);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	//
	// @Override
	// public ResponseEntity<Product> updateProduct(ProductRequest productRequest) {
	//
	// Optional<Product> product =
	// productRepository.findById(productRequest.getProductId());
	// if (product.isPresent()) {
	// ObjectMapper objectMapper = new ObjectMapper();
	// Product isProduct = objectMapper.convertValue(productRequest, Product.class);
	// return ResponseEntity.ok(productRepository.save(isProduct));
	// }
	// return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	// }
	//
	// @Override
	// public ResponseEntity<List<Product>> getAllProducts() {
	//
	// List<Product> producta = productRepository.findAll();
	// if (!producta.isEmpty()) {
	// return ResponseEntity.ok(producta);
	// }
	// return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	// }
	//
	// @Override
	// public ResponseEntity<String> deleteProductById(Long productId) {
	//
	// productRepository.deleteById(productId);
	// return new ResponseEntity<String>("Product id not excits in table",
	// HttpStatus.NO_CONTENT);
	//
	// }
	//
	// @Override
	// public ResponseEntity<List<Product>> getByProductName(String productName) {
	//
	// if (!ObjectUtils.isEmpty(productRepository.getByProductName(productName))) {
	// return ResponseEntity.ok(productRepository.getByProductName(productName));
	// }
	// return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	// }

}
