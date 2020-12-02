package com.demo.spring.dao.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

//@Component
@Repository
public class EmpDaoMockImpl implements EmpDao,BeanPostProcessor {

	public String save(Emp e) {

		return "Mock: Emp saved with id " + e.getEmpid();
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean Name = "+beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean Name = "+beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
}
