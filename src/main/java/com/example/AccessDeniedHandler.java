package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

public class AccessDeniedHandler extends AccessDeniedHandlerImpl{
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		this.logger.error("AccessDenied", accessDeniedException);
		super.handle(request, response, accessDeniedException);
	}

}
