package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.example.entity.User;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User loginUser = (User) authentication.getPrincipal();
		System.out.println("==========================="+loginUser.getUsername()+"===========================");
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
