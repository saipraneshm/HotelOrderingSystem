package com.cmpe275.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	
    public String index() {
		System.out.println("I reach here");
        return "index";
    
	}
}
