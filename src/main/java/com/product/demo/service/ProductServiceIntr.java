package com.product.demo.service;

import java.util.List;

import com.product.demo.entity.Product;
import com.product.demo.request.ProductRequest;

public interface ProductServiceIntr {

	Product createProduct(ProductRequest productRequest);

	List<Product> getMaxSoldProduct();

}
