package com.example.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.MyUserDetailServiceImpl;

import eu.bitwalker.useragentutils.UserAgent;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	final Log log = LogFactory.getLog(getClass());
	@RequestMapping("/")
	public String index(){
		return "app/login";
	}
	
	@Autowired
	MyUserDetailServiceImpl userService;
	
	@RequestMapping("/in")
	public String home(User user, HttpServletRequest req){
//		String queryString = req.getQueryString();
//		System.out.println(queryString);
//		String userAgentStr = req.getHeader("User-Agent");
//		System.out.println(userAgentStr.toString());
//		UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
//		UserDetails userdetail = userService.loadUserByUsername(user.getUsername());
//		SecurityContext context = SecurityContextHolder.getContext();
//		Authentication auth = context.getAuthentication();
//		String name = auth.getName();
//		System.out.println(name);
//		if(auth.getPrincipal() != null){
//			User u = (User) auth.getPrincipal();
//			System.out.println(u.getUsername());
//		}
//		log.info("==============");
		System.out.println(1111111);
		return "app/home";
	}
	@RequestMapping("/out")
	public String out(User user,HttpServletRequest request,HttpServletResponse response){
		//UserDetails userdetail = userService.loadUserByUsername(user.getUsername());
		 // 清除session
		        Enumeration<String> em = request.getSession().getAttributeNames();
		        while (em.hasMoreElements()) {
		            request.getSession().removeAttribute(em.nextElement().toString());
		        }
//		        request.getSession().removeAttribute();
		        request.getSession().invalidate();

		return "login";
	}
}
