package com.wellsfaro.fsd.sba2.coronakit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProductMaster {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Product Name cannot be a null value")
	@Size(min=3,message="Product Name should be min of 3 characters")
	private String productName;
	
	@NotNull(message="Product cost cannot be a null value")
	@Min(value=10,message="Product Cost must be more than or equals to 10")
	private Double cost;
	
	@NotNull(message="Product Description cannot be a null value")
	@Size(min=5,message="Product Description should be min of 5 characters")
	private String productDescription;
	
	public ProductMaster() {
		// left
	}
	
	public ProductMaster(int id, String productName, double i, String productDescription) {
		super();
		this.id = id;
		this.productName = productName;
		this.cost = i;
		this.productDescription = productDescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "ProductMaster [id=" + id + ", productName=" + productName + ", cost=" + cost + ", productDescription="
				+ productDescription + "]";
	}

}

	


