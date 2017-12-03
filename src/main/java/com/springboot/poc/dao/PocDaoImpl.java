/**
 *
 */
package com.springboot.poc.dao;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.poc.domain.PmCustomerLogin;

/**
 * @author Romil
 */
@Repository
public class PocDaoImpl implements PocDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /* (non-Javadoc)
     * @see com.apple.poc.dao.PocDao#getContainerIssues(java.lang.String)
     */
    public PmCustomerLogin validateCustomer(String customerEmailId) {
        System.out.println("in Dao -- validateCustomer");
        PmCustomerLogin pmCustomerLogin = null;
        List<?> pmCustomerLoginList = hibernateTemplate.findByNamedQueryAndNamedParam("getCustomerLoginByEmailId", "customerEmailId", customerEmailId);
        if(CollectionUtils.isNotEmpty(pmCustomerLoginList)){
        	pmCustomerLogin = (PmCustomerLogin)pmCustomerLoginList.get(0);
        }
        return pmCustomerLogin;
    }

    /* (non-Javadoc)
	 * @see com.apple.poc.dao.PocDao#getIssueDetails(java.lang.String)
	 */
    @Transactional(propagation=Propagation.SUPPORTS)
    public void registerCustomer(PmCustomerLogin pmCustomerLogin) {
    	System.out.println("in Dao -- registerCustomer");
    	hibernateTemplate.save(pmCustomerLogin);
    }

	@Override
	public PmCustomerLogin getCustomerDetails(String customerEmailId) {
		System.out.println("in Dao -- registerCustomer");	
		PmCustomerLogin pmCustomerLogin = null;
        List<?> pmCustomerLoginList = hibernateTemplate.findByNamedQueryAndNamedParam("getCustomerLoginByEmailId", "customerEmailId", customerEmailId);
        if(CollectionUtils.isNotEmpty(pmCustomerLoginList)){
        	pmCustomerLogin = (PmCustomerLogin)pmCustomerLoginList.get(0);
        }
        return pmCustomerLogin;
	}


}
