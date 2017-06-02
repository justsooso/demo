package com.example;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class TestController {

	@RequestMapping("/home")
	public String test(){
		return "app/index";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello() {
     return new ModelAndView("hello");
    }
	
	 @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) throws Exception {
        model.addAttribute("name", name);
        int i=1;
        if(i==1){
//        	try {
        		//throw new Exception("就是这么任性！");
				
//			} catch (Exception e) {
				// TODO: handle exception
//			}/
        }
        return "app/hello2";
    }
	 
	@RequestMapping("/hi")
	public String index(HttpServletRequest req){
		String shop = req.getParameter("shop");
		System.out.println(shop);
//		req.getpr
		System.out.println("".equals(shop));
		if(req.getParameter("shop")!=null&&!"".equals(shop)){
			System.out.println(shop+"===========");
		}else{
			System.out.println(shop==null);
		}
//		Object bean = SpringContextHolder.getApplicationContext().getBean("demoService");
		
		
		return "html/hello";
	}
	final Log log = LogFactory.getLog(getClass());
//	@Autowired
//	UserDao userDao;
	
	@RequestMapping("/user")
	public String insert(String name) {
//		User user = new User();
//		user.setUsername(name);
//		userDao.save(user);
//		//int i ;
	//	if(name ==null)  i = 1/0;
		//throw new Exception();
		
		return "app/index";
	}
	
	public void reflectMethod(){
		System.out.println("reflect **************");
		
	}
}
