/**
 * 
 */
package com.springboot.poc.bean;

/**
 * @author Romil
 *
 */
public class CustomerDetailsTO extends CustomerLoginTO {
	
	private String customerAddress;
	private String customerSex;
	private Integer customerAge;
	private String customerLocality;
	private String customerCity;
	private String customerState;
	private String customerCountry;

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerLocality() {
		return customerLocality;
	}

	public void setCustomerLocality(String customerLocality) {
		this.customerLocality = customerLocality;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

}
