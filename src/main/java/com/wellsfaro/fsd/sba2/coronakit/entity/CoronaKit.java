package com.wellsfaro.fsd.sba2.coronakit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coronakitdetails") 
public class CoronaKit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Embedded
	private UserAddress deliveryAddress;
	
	@Column(name="OrderDate")
	private LocalDate orderDate;
	
	@Column(name="TotalAmount")
	private double totalAmount;
	
	public CoronaKit() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public UserAddress getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(UserAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalamount2) {
		this.totalAmount = totalamount2;
	}

	



}
