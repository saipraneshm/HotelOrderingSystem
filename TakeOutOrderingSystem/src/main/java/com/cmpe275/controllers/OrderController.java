package com.cmpe275.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cmpe275.domain.*;
import com.cmpe275.repository.OrderRepository;

import com.cmpe275.repository.UserRepository;
@RestController
public class OrderController {

@Autowired
private OrderRepository orderRepository;
@Autowired
private UserRepository userRepository;


@RequestMapping(value="/placeOrder", method = RequestMethod.POST)
public String placeOrder(@RequestBody Order order){
	
	
	System.out.println("hey an here");
	
	
	//int  userId = (int) request.getSession().getAttribute("userId");
	User user = userRepository.findByUserId(1);
	System.out.println(user);
	order.setUser(user);
	System.out.println("Here");
	orderRepository.save(order);
	
	
	System.out.println("ordersMenu");
	
	return "success";

}




}
