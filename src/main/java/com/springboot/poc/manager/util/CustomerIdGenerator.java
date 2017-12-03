/**
 * This class is generated on Mar 18, 2015
 * @author PepWiz Tech
 *
 */
package com.springboot.poc.manager.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * 
 */
public class CustomerIdGenerator {
	
	private static SecureRandom random = null;
	
	public static synchronized String getUniqueId(String key) {
		String uniqueKy = null;
		if (key.equalsIgnoreCase("Customer")) {
			uniqueKy = "CT";
		}
		SecureRandom random = getRandomNumber();
		String uniqueId = uniqueKy.concat(new BigInteger(48, random).toString(32).toUpperCase());
		return uniqueId;
	}
	
	public static synchronized SecureRandom getRandomNumber(){
		if(null==random){
			random = new SecureRandom();
		}
		return random;
	}
}
