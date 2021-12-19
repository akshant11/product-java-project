package com.product.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.entity.Product;
import com.product.demo.request.ProductRequest;
import com.product.demo.response.StatusResponse;
import com.product.demo.service.ProductServiceIntr;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductServiceIntr productServiceIntr;

	StatusResponse statusResponse = new StatusResponse();

	// create new product
	@PostMapping("/product")
	public StatusResponse createProduct(@RequestBody ProductRequest productRequest) {

		if (!productServiceIntr.isExist(productRequest)) {
			productServiceIntr.createProduct(productRequest);

			statusResponse.setMessage("Product create successfully..");
			statusResponse.setStatus("Ok..");
			return statusResponse;
		}

		statusResponse.setMessage("Product already exists.. ");
		statusResponse.setStatus("Not ok.. ");
		return statusResponse;
	}

	// get max sold products
	@GetMapping("/products/maxSold")
	public ResponseEntity<List<Product>> getMaxSoldProduct() {

		return productServiceIntr.getMaxSoldProduct();
	}

//	// get all product
//	@GetMapping("/products")
//	public ResponseEntity<List<Product>> getAllProducts() {
//
//		return productServiceIntr.getAllProducts();
//
//	}
//
//	// get by product name
//	@GetMapping("/productsByName/{productName}")
//	public ResponseEntity<List<Product>> getByProductName(@PathVariable String productName) {
//
//		return productServiceIntr.getByProductName(productName);
//
//	}
//
//	// update product by id
//	@PutMapping("/updateProducts")
//	public ResponseEntity<Product> updateProduct(@RequestBody ProductRequest productRequest) {
//
//		return productServiceIntr.updateProduct(productRequest);
//	}
//
//	// delete product by id
//	@DeleteMapping("/product/{id}")
//	public ResponseEntity<String> deleteProductById(@PathVariable("id") Long productId) {
//
//		return productServiceIntr.deleteProductById(productId);
//
//	}

}
