/**
 * 
 */
package com.springboot.poc.dao;

import com.springboot.poc.domain.PmCustomerLogin;

/**
 * @author Romil
 *
 */
public interface PocDao {

	public PmCustomerLogin validateCustomer(String customerEmailId);

	public void registerCustomer(PmCustomerLogin pmCustomerLogin);

	public PmCustomerLogin getCustomerDetails(String customerEmailId);

}
