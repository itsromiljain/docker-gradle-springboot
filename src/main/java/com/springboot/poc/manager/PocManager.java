/**
 * 
 */
package com.springboot.poc.manager;

import com.springboot.poc.bean.CustomerDetailsTO;
import com.springboot.poc.bean.CustomerLoginTO;
import com.springboot.poc.bean.CustomerRegistrationTO;

/**
 * @author Romil
 *
 */
public interface PocManager {
	
	public String validateCustomer(CustomerLoginTO customerLoginTO);

	public void registerCustomer(CustomerRegistrationTO customerRegistrationTO);
	
	public CustomerDetailsTO getCustomerDetails(String customerEmailId);

}
