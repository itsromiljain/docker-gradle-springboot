/**
 * 
 */
package com.springboot.poc.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.poc.bean.CustomerDetailsTO;
import com.springboot.poc.bean.CustomerLoginTO;
import com.springboot.poc.bean.CustomerRegistrationTO;
import com.springboot.poc.dao.PocDao;
import com.springboot.poc.domain.PmCustomerLogin;
import com.springboot.poc.manager.util.PocManagerUtil;

/**
 * @author Romil
 *
 */
@Repository(value = "pocManagerImpl")
public class PocManagerImpl implements PocManager {

	@Autowired
	private PocDao pocDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.apple.poc.manager.PocManager#getContainerIssues(java.lang.String)
	 */
	public String validateCustomer(CustomerLoginTO customerLoginTO) {
		System.out.println("in Manager -- validateCustomer");
		PmCustomerLogin pmCustomerLogin = pocDao.validateCustomer(customerLoginTO.getEmailId());
		String message = null;
		if (null != pmCustomerLogin) {
			if(customerLoginTO.getPwd().equals(pmCustomerLogin.getPmHashPassword())){
				//Customer is valid
				message = "Authentic Customer";
			}else{
				//Customer is not valid
				message = "Customer is not Authentic";
			}
		}else{
			//Customer doesn't exist
			message = "Customer doesn't exist";
		}
		return message;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.apple.poc.manager.PocManager#getIssueDetails(java.lang.String)
	 */
	public void registerCustomer(CustomerRegistrationTO customerRegistrationTO) {
		System.out.println("in Manager -- registerCustomer");
		PmCustomerLogin pmCustomerLogin = PocManagerUtil.convertTrnsfrObjectToPojo(customerRegistrationTO);
		pocDao.registerCustomer(pmCustomerLogin);
	}

	@Override
	public CustomerDetailsTO getCustomerDetails(String customerEmailId) {
		System.out.println("in Manager -- getCustomerDetails");
		PmCustomerLogin pmCustomerLogin = pocDao.getCustomerDetails(customerEmailId);
		CustomerDetailsTO customerDetailsTO = new CustomerDetailsTO();
		if (null != pmCustomerLogin) {
			customerDetailsTO = PocManagerUtil.convertPojoToTrnsfrObject(pmCustomerLogin, customerDetailsTO);
			
		}
		return customerDetailsTO;
	}

}
