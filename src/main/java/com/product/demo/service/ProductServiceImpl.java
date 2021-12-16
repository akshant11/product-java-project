package com.product.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Product> getMaxSoldProduct() {
		
		return productRepository.getByQuantitySold();

	}

}
