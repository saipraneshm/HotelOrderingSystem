package com.cmpe275.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user_email")
public class PageController {
	
	@RequestMapping("/addMenuItem")
	public String add_menu_item(){
		
		return "add_menu_item";
	}
	@RequestMapping("/adminLogin")
	public String admin_login(){
		
		return "admin_login";
	}
	
	@RequestMapping("/home")
	
	public String home(HttpServletRequest request){
		System.out.println(request.getSession().getAttribute("user_email"));
		if(request.getSession().getAttribute("user_email") != null){
    		return "home";
    	}else{
    		return "userLogin";
    	}
	}
	
    @RequestMapping("/userHome")
	
	public String userHome(){
    	return "userHome";
		
	}
    
    @RequestMapping("/cart")
    public String  cart(){
    	return "cart";
    }
    
    @RequestMapping("/checkout")
    public String  checkout(){
    	return "checkout";
    }
    
    @RequestMapping("/")
    public String userLogin(HttpServletRequest request){
    	if(request.getSession().getAttribute("user_email") != null){
    		return "home";
    	}else{
    		return "userLogin";
    	}
    	
    }
    
    @RequestMapping("/authenticatePin")
    public String authenticatePin(){
    	return "verifyCode";
    }


}
