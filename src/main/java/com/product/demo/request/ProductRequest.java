package com.product.demo.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6475613409199084558L;
	
	private Long Price;
	private String productName;
	private Long quantitySold;
}
