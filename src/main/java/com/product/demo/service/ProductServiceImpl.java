package com.product.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.demo.entity.Product;
import com.product.demo.repository.ProductRepository;
import com.product.demo.request.ProductDto;

@Service
public class ProductServiceImpl implements ProductServiceIntr {

	@Autowired
	private ProductRepository productRepository;

	ObjectMapper objectMapper = new ObjectMapper();

	
	@Override
	// create new product
	public ProductDto createProduct(ProductDto productDto) {

		Product product = objectMapper.convertValue(productDto, Product.class);
		productRepository.save(product);
		return objectMapper.convertValue(productRepository.save(product), ProductDto.class);
	}

	@Override
	// get max sold product
	public ResponseEntity<List<Product>> getMaxSoldProduct() {

		if (!productRepository.getByQuantitySold().isEmpty()) {
			return ResponseEntity.ok(productRepository.getByQuantitySold());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Override
	// check product exist or not
	public boolean isExist(ProductDto productDto) {

		if (!ObjectUtils.isEmpty(productRepository.getByProductName(productDto.getProductName()))) {
			return true;
		}
		return false;
	}

	@Override
	// update product  by id
	public ResponseEntity<Product> updateProduct(ProductDto productRequest) {

		if (productRepository.findById(productRequest.getProductId()).isPresent()) {
			Product isProduct = objectMapper.convertValue(productRequest, Product.class);
			return ResponseEntity.ok(productRepository.save(isProduct));
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Override
	// get all product
	public ResponseEntity<List<Product>> getAllProducts() {

		if (!productRepository.findAll().isEmpty()) {
			return ResponseEntity.ok(productRepository.findAll());
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Override
	// delete product by id
	public ResponseEntity<String> deleteProductById(Long productId) {

		productRepository.deleteById(productId);
		return new ResponseEntity<String>("Product id not excits in table", HttpStatus.NO_CONTENT);

	}

	@Override
	// get by product name
	public ResponseEntity<Product> getByProductName(String productName) {

		if (!ObjectUtils.isEmpty(productRepository.getByProductName(productName))) {
			return ResponseEntity.ok(productRepository.getByProductName(productName));
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
