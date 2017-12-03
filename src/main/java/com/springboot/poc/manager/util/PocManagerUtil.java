/**
 * 
 */
package com.springboot.poc.manager.util;

import java.util.HashSet;
import java.util.Set;

import com.springboot.poc.bean.CustomerDetailsTO;
import com.springboot.poc.bean.CustomerRegistrationTO;
import com.springboot.poc.domain.PmCustomerLogin;
import com.springboot.poc.domain.PmCustomerProfile;

/**
 * @author Romil
 *
 */
public class PocManagerUtil {

	public static PmCustomerLogin convertTrnsfrObjectToPojo(CustomerRegistrationTO customerRegistrationTO) {
		PmCustomerLogin pmCustomerLogin = new PmCustomerLogin();
		pmCustomerLogin.setPmCustomerUniqueId(CustomerIdGenerator.getUniqueId("Customer"));
		pmCustomerLogin.setPmEmailId(customerRegistrationTO.getEmailId());
		pmCustomerLogin.setPmHashPassword(customerRegistrationTO.getPwd());
		pmCustomerLogin.setPmMobileNo(customerRegistrationTO.getMobNo());
		pmCustomerLogin.setPmLoginSource("POC");
		PmCustomerProfile pmCustomerProfile = convertTrnsfrObjectToProfilePojo(customerRegistrationTO);
		pmCustomerProfile.setPmCustomerLogin(pmCustomerLogin);
		Set<PmCustomerProfile> pmCustomerProfiles = new HashSet<PmCustomerProfile>();
		pmCustomerProfiles.add(pmCustomerProfile);
		pmCustomerLogin.setPmCustomerProfiles(pmCustomerProfiles);
		return pmCustomerLogin;
	}

	public static PmCustomerProfile convertTrnsfrObjectToProfilePojo(CustomerRegistrationTO customerRegistrationTO) {
		PmCustomerProfile pmCustomerProfile = new PmCustomerProfile();
		pmCustomerProfile.setPmCustomerAddress(customerRegistrationTO.getCustomerAddress());
		pmCustomerProfile.setPmCustomerAge(customerRegistrationTO.getCustomerAge());
		pmCustomerProfile.setPmCustomerCity(customerRegistrationTO.getCustomerCity());
		pmCustomerProfile.setPmCustomerCountry(customerRegistrationTO.getCustomerCountry());
		pmCustomerProfile.setPmCustomerLocality(customerRegistrationTO.getCustomerLocality());
		pmCustomerProfile.setPmCustomerSex(customerRegistrationTO.getCustomerSex());
		pmCustomerProfile.setPmCustomerState(customerRegistrationTO.getCustomerState());
		return pmCustomerProfile;
	}

	public static CustomerDetailsTO convertPojoToTrnsfrObject(PmCustomerLogin pmCustomerLogin, CustomerDetailsTO customerDetailsTO) {
		customerDetailsTO.setEmailId(pmCustomerLogin.getPmEmailId());
		customerDetailsTO.setMobNo(pmCustomerLogin.getPmMobileNo());
		customerDetailsTO.setCustomerUniqueId(pmCustomerLogin.getPmCustomerUniqueId());
		customerDetailsTO.setCustomerName(pmCustomerLogin.getPmCustomerName());
		Set<PmCustomerProfile> customerProfiles = pmCustomerLogin.getPmCustomerProfiles();
		for(PmCustomerProfile pmCustomerProfile : customerProfiles){
			customerDetailsTO.setCustomerAddress(pmCustomerProfile.getPmCustomerAddress());
			customerDetailsTO.setCustomerAge(pmCustomerProfile.getPmCustomerAge());
			customerDetailsTO.setCustomerCity(pmCustomerProfile.getPmCustomerCity());
			customerDetailsTO.setCustomerCountry(pmCustomerProfile.getPmCustomerCountry());
			customerDetailsTO.setCustomerLocality(pmCustomerProfile.getPmCustomerLocality());
			customerDetailsTO.setCustomerSex(pmCustomerProfile.getPmCustomerSex());
			customerDetailsTO.setCustomerState(pmCustomerProfile.getPmCustomerState());
		}
		return customerDetailsTO;
	}

}
