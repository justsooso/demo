package com.example.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class HtmlController {
	
	final Log log = LogFactory.getLog(getClass());
	@RequestMapping("/whale")
	public String index(HttpServletRequest req){
		System.out.println("req ============================");
		System.out.println("req ip :" + req.getRemoteHost());
		System.out.println(req.getRemoteUser());
		System.out.println(req.getRemoteAddr());
		return "html/whale";
	}
	
	@RequestMapping("/matrix")
	public String matrix(HttpServletRequest req){
		System.out.println("req ============================");
		System.out.println("req ip :" + req.getRemoteHost());
		System.out.println(req.getRemoteUser());
		System.out.println(req.getRemoteAddr());
		return "html/matrix";
	}
	
	@RequestMapping("/tunnel")
	public String tunnel(HttpServletRequest req){
		System.out.println("req ============================");
		System.out.println("req ip :" + req.getRemoteHost());
		System.out.println(req.getRemoteUser());
		System.out.println(req.getRemoteAddr());
		return "html/tunnel";
	}
	
}
