package com.example;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.entity.MyUserDetails;
import com.example.service.MyUserDetailServiceImpl;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{
	
	 @Autowired
	 private MyUserDetailServiceImpl userDetailService;

	 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String username = authentication.getName();
	        String password = (String) authentication.getCredentials();
	        MyUserDetails user = (MyUserDetails) userDetailService.loadUserByUsername(username);
	        if(user == null){
	            throw new BadCredentialsException("Username not found.");
	        }

	        //加密过程在这里体现
	        if (!password.equals(user.getPassword())) {
	            throw new BadCredentialsException("Wrong password.");
	        }

	        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
	        return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
