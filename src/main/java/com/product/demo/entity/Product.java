package com.product.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductId")
	private Long productId;
	@Column(name = "Price")
	private Long price;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "QuantitySold")
	private Long quantitySold;
	
}
