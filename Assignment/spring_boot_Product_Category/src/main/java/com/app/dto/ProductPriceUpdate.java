package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductPriceUpdate {
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long id;
	private double price;
	public ProductPriceUpdate() {
		// TODO Auto-generated constructor stub
	}
}
