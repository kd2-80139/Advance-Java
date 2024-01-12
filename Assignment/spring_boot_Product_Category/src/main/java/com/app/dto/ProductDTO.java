package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	@NotBlank(message = "Product Name Required")
	private String name;
	private String description;
	@Min(value = 1000,message = "Price Must be Greater Than 1000")
	private double price;
	private int stock;
	@Future(message = "Expired Product Not Allowed")
	private LocalDate expDate;
	private String categotyName;
	
}
