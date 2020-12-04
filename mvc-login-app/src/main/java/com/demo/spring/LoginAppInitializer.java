package com.demo.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LoginAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
public LoginAppInitializer() {
	System.out.println("LoginApp Initializer..");
}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses called..");
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings called..");
		return new String[] {"/"};
	}

}
