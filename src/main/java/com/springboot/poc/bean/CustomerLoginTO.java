/**
 * 
 */
package com.springboot.poc.bean;

/**
 * @author Romil
 *
 */
public class CustomerLoginTO {
	
	private String emailId;
	
	private String pwd;
	
	private String customerName;
	
	private String mobNo;
	
	private String customerUniqueId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getCustomerUniqueId() {
		return customerUniqueId;
	}

	public void setCustomerUniqueId(String customerUniqueId) {
		this.customerUniqueId = customerUniqueId;
	}
	
}
