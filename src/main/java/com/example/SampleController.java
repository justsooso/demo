package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  
@ComponentScan  
@EnableAutoConfiguration
@SpringBootApplication
public class SampleController {
	
//	 	@RequestMapping("/app")
//	    @ResponseBody
//	    String home() {
//	        return "Hello World!";
//	    }

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(SampleController.class, args);
	    }
	    
}
