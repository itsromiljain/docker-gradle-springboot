/**
 * 
 */
package com.springboot.poc.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Romil
 *
 */
@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:hibernateConfig.xml" })
public class HibernateConfig {

}
