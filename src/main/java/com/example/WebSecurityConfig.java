package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.util.ObjectUtils;

import com.example.service.MyUserDetailServiceImpl;



@Configurable
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	static final String[] permitAllUrl = new String[] {"/html/**", "/app/**", "/login/**", "/lib/**", "/static/**" ,"/resources/static"};
	
	public final static String[] excludeUrl = {"html/**", "/css/**", "/js/**", "/image/**", "/img/**", "/favicon.ico", "**/favicon.ico", "/lib/**", "/static/**","/manager/**","/shop/**","/base/**","/forApp/**", "/robot.txt","/b2c/**" };
	
	@Autowired
    private MyAuthenticationProvider provider;//自定义验证
    @Autowired
    private MyUserDetailServiceImpl userDetailsService;//自定义用户服务
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
    	
    	 auth.authenticationProvider(provider);
    	 auth
         .inMemoryAuthentication()
             .withUser("user").password("123456").roles("USER");
    }
    
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()

	        .antMatchers(permitAllUrl).permitAll();//无需访问权限
//
////	        .antMatchers("/app/**").hasRole("admin")//admin角色访问权限
////
//	        .antMatchers("/appss/**").hasRole("role_user")//user角色访问权限
//
//	        .anyRequest()//all others request authentication
//	        .authenticated()
//	        .and()
//	        .formLogin().loginPage("/login/").permitAll()
////	        .defaultSuccessUrl("/main", true).failureUrl("/login?failure"));
//	        .and()
//	        .logout().permitAll();
		 super.configure(http);
	    }


	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
//		List<String> ignored = SpringBootWebSecurityConfiguration.getIgnored(this.props);
		String[] paths = excludeUrl;
		if (!ObjectUtils.isEmpty(paths)) {
			web.ignoring().antMatchers(paths);
		}
	}
	
	
	
	
}
	
	
