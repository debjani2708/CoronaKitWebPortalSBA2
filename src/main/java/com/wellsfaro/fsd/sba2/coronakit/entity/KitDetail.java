package com.wellsfaro.fsd.sba2.coronakit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Kitdetails")
public class KitDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int coronaKitId;
	@Column
	private int productId;
	@Column
	private String productFullName;	

	@Column
	private int quantity;
	@Column
	private double amount;
	
	public KitDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public KitDetail(int id, int coronaKitId, int productId,String productFullName, int quantity, double amount) {
		this.id = id;
		this.coronaKitId = coronaKitId;
		this.productId = productId;
		this.productFullName=productFullName;
		this.quantity = quantity;
		this.amount = amount;
	}
	

	public KitDetail( int coronaKitId, int productId,String productFullName, int quantity, double d) {		
		this.coronaKitId = coronaKitId;
		this.productId = productId;
		this.productFullName=productFullName;
		this.quantity = quantity;
		this.amount = d;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoronaKitId() {
		return coronaKitId;
	}
	public void setCoronaKitId(int coronaKitId) {
		this.coronaKitId = coronaKitId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getProductFullName() {
		return productFullName;
	}

	public void setProductFullName(String productFullName) {
		this.productFullName = productFullName;
	}
	
	
	
	
}
