package com.cmpe275.controllers;

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
}
