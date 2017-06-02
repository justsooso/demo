package com.example.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.MyUserDetails;
import com.example.entity.Role;
import com.example.entity.User;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService{
	
	@Resource(name = "userService")
    private UserService userService;

    @Resource(name = "roleService")
    private RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 User user;
	        try {
	            user = userService.findByName(userName);
	        } catch (Exception e) {
	            throw new UsernameNotFoundException("user select fail");
	        }
	        if(user == null){
	            throw new UsernameNotFoundException("no user found");
	        } else {
	            try {
	                List<Role> roles = roleService.getRoleByUser(user);
	                SecurityContext context = SecurityContextHolder.getContext();
	                Authentication authentication = new UsernamePasswordAuthenticationToken(    
	                		user, user.getPassword() ); 
	                
	                context.setAuthentication(authentication);
	                return new MyUserDetails(user, roles);
	                
	            } catch (Exception e) {
	                throw new UsernameNotFoundException("user role select fail");
	            }
	        }
	}

	

}
