package com.cmpe275.controllers;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.domain.Order;
import com.cmpe275.domain.Orders_Menu;
import com.cmpe275.domain.User;
import com.cmpe275.repository.OrderRepository;
import com.cmpe275.repository.OrdersMenuRepository;
import com.cmpe275.repository.UserRepository;

@RestController
public class OrderController {

@Autowired
private OrderRepository orderRepository;
@Autowired
private UserRepository userRepository;

@Autowired
private OrdersMenuRepository ordersMenuRepo;

@RequestMapping(value="/placeOrder", method = RequestMethod.POST)
public String placeOrder(@RequestBody Orders_Menu[] orders, HttpServletRequest req){
	
	
	/*System.out.println("hey an here");
	 System.out.println("Order details");
	 System.out.println(order);
	JSONObject json = new JSONObject(order);
	System.out.println(json.toString());
	int  userId =(int) req.getSession().getAttribute("userId");
	User user = userRepository.findByUserId(1);
	order.setOrderId(order.getOrderId()+Integer.toString(user.getUserId()));  
	order.setUser(user);
	System.out.println("Here");
	Order orders = orderRepository.save(order);*/
	
	for(int i = 0 ; i < orders.length; i ++ ){
		ordersMenuRepo.save(orders[i]);
	}
	
	
	
	
	
	System.out.println("ordersMenu");
	
	return "success";

}




}
