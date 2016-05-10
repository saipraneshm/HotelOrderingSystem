package com.cmpe275.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.domain.Menu;
import com.cmpe275.repository.MenuRepository;


@RestController
public class adminController {

	@Autowired
	private MenuRepository menuRepository;
	@RequestMapping(value = "/item_add", method = RequestMethod.POST)
	@ResponseBody
	public void add_item(@RequestBody Menu menu){
		System.out.println("heyy reached here");
		//menuRepository.save(menu);
		System.out.println("calories :"+menu.getCalories());
		System.out.println("Name :"+menu.getName());
		System.out.println("path :"+menu.getImagePath());
		System.out.println("time :"+menu.getPreparationTime());
		System.out.println("quantity: "+menu.getQuantity());
		System.out.println("price "+menu.getUnitPrice());
		menuRepository.save(menu);
	}
	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	@ResponseBody
	public String verify(@RequestBody String json)
	{
		
		JSONObject jsonObject = new JSONObject(json);
		JSONObject response = new JSONObject();
		String username=jsonObject.get("username").toString();
		String password=jsonObject.getString("password").toString();
		
		System.out.println("Got this username "+username);
		System.out.println("Got this password "+password);
		if(username.equals("admin") && password.equals("admin"))
		{
			response.append("status", 200);
		}
		else
		{
			response.append("status", 404);
		}
			
		return response.toString();
		
		
	}
	
}
