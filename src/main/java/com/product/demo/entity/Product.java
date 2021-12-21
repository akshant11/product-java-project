package com.product.demo.entity;

import java.io.Serializable;

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
public class Product implements Serializable {
	
	private static final long serialVersionUID = 7990990475992677604L;

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
