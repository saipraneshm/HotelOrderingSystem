package com.cmpe275.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.domain.Menu;
import com.cmpe275.repository.MenuRepository;


@RestController
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;
	
	@RequestMapping(value = "/getMenuItems", method = RequestMethod.GET)
	@ResponseBody
	public List<Menu> getItems(){
		
		Iterable<Menu> it =  menuRepository.findAll();
		Iterator iterator = it.iterator();
		List<Menu> menu = new ArrayList<>();
		while(iterator.hasNext()){
			menu.add((Menu)iterator.next());
		}
		return menu;
	}
}
