package com.cmpe275.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user_email")
public class PageController {

	@RequestMapping("/")
    public String index() {
		System.out.println("I reach here");
        return "index";
    
	}
	
	
	@RequestMapping("/home")
	
	public String home(){
		return "home";
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
    
    @RequestMapping("/userLogin")
    public String userLogin(){
    	return "userLogin";
    }
    
    @RequestMapping("/authenticatePin")
    public String authenticatePin(){
    	return "verifyCode";
    }


}
