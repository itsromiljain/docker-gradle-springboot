/**
 * 
 */
package com.springboot.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.poc.bean.CustomerDetailsTO;
import com.springboot.poc.bean.CustomerLoginTO;
import com.springboot.poc.bean.CustomerRegistrationTO;
import com.springboot.poc.manager.PocManager;

/**
 * @author Romil
 *
 */
@SpringBootApplication
@RestController
@ComponentScan
@Configuration
@EnableAutoConfiguration
public class PocService {
	
	public static void main(String[] args) {
        SpringApplication.run(PocService.class, args);
    }

	@Autowired
	private PocManager pocManager;
	
	/*
	 * http://localhost:8080/validateCustomer
	 * */
    @RequestMapping(value="/validateCustomer", method=RequestMethod.POST)
    public String validateCustomer(@RequestBody CustomerLoginTO customerLoginTO){
    	System.out.println(customerLoginTO.getEmailId());
        String message = pocManager.validateCustomer(customerLoginTO);
        return message;
    }

    /*
     * http://localhost:8080/registerCustomer
     * */
    @RequestMapping(value="/registerCustomer", method=RequestMethod.POST)
    public void registerCustomer(@RequestBody CustomerRegistrationTO customerRegistrationTO){
    	System.out.println(customerRegistrationTO.getEmailId());
        pocManager.registerCustomer(customerRegistrationTO);
    }
    
    /*
     * http://localhost:8080/customerDetails
     * */
    @RequestMapping(value="/customerDetails", method=RequestMethod.POST)
    public CustomerDetailsTO customerDetails(@RequestBody CustomerLoginTO customerLoginTO){
        System.out.println("CustomerEmailId-"+customerLoginTO.getEmailId());
        CustomerDetailsTO customerDetailsTO = pocManager.getCustomerDetails(customerLoginTO.getEmailId());
        return customerDetailsTO;
    }
    
}
