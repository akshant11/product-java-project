package com.product.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.entity.Product;
import com.product.demo.request.ProductRequest;
import com.product.demo.service.ProductServiceIntr;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductServiceIntr productServiceIntr;

	@PostMapping("/products")
	public Product createProduct(@RequestBody ProductRequest productRequest) {

		return productServiceIntr.createProduct(productRequest);
	}

	@GetMapping("/products/maxSold")
	public List<Product> getMaxSoldProduct() {

		return productServiceIntr.getMaxSoldProduct();
	}

}
