package com.wellsfaro.fsd.sba2.coronakit.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Embeddable
public class UserAddress {
	
	@NotNull(message="Address1 cannot be null value")
	@NotBlank(message="Address1 cannot be blank value")
	private String Address1;
	
	@NotNull(message="Address2 cannot be null value")
	@NotBlank(message="Address2 cannot be blank value")
	private String Address2;
	
	@NotNull(message="City cannot be null value")
	@NotBlank(message="City cannot be blank value")
	private String City;
	
	@NotNull(message="State cannot be null value")
	@NotBlank(message="State cannot be blank value")
	private String State;
	
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	

}
