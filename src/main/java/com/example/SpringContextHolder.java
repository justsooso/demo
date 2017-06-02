package com.example;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware{
	
	static ApplicationContext context ;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
	
		SpringContextHolder.context = context;
	}
	
	public static ApplicationContext getApplicationContext(){
		return context;
	}

}
