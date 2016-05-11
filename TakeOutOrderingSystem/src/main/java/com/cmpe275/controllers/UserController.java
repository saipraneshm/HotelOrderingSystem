package com.cmpe275.controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.domain.User;
import com.cmpe275.repository.UserRepository;
import com.cmpe275.util.VerifyCodeGeneratorImpl;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VerifyCodeGeneratorImpl codeGenerator;
	
	private JSONObject jsonObject;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
    public List<User> registerUser() {
        
		User user = new User();
		user.setUserId(56);
		userRepository.save(user);
		
		System.out.println(userRepository.findByUserIdLessThan(60).size());
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			result= mapper.writeValueAsString(userRepository.findByUserIdLessThan(60).get(0));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRepository.findByUserIdLessThan(60);
    }


	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@ResponseBody
	public String signup(@RequestBody User user, HttpServletRequest request){
		
		jsonObject = new JSONObject();
		request.getSession().setAttribute("user_email", user.getEmail());
		System.out.println(user.getEmail() + " " + user.getPassword());
		int authCode = codeGenerator.codeGenerator(user.getFirstname(),user.getEmail());
		user.setActivationCode(authCode);
		User checkUser = userRepository.save(user);
		if(checkUser != null){
			jsonObject.append("status", 200);
		}else{
			jsonObject.append("status", 400);
		}
	
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/validatePin", method = RequestMethod.POST)
	@ResponseBody
	public String validatePin(@RequestBody User user, HttpServletRequest request){
	
		System.out.println("inside validate pin");
		String email = (String) request.getSession().getAttribute("user_email");
		User checkUser = userRepository.findByEmail(email);
		JSONObject jsonObject = new JSONObject();
		if( checkUser.getActivationCode() == user.getActivationCode()){
			checkUser.setStatus(1);
			userRepository.save(checkUser);
			jsonObject.append("status", 200);
		}else{
			jsonObject.append("status", 400);
		}
		return jsonObject.toString();
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String userLogin(@RequestBody User user, HttpServletRequest request){
		JSONObject jsonObject = new JSONObject();
		String email = user.getEmail();
		String password = user.getPassword();
		int status = user.getStatus();
		System.out.println(status);
		User checkUser = new User(); 
			checkUser =	userRepository.findByEmail(email);
		System.out.println(checkUser.getEmail() + " " + checkUser.getPassword());
		if(checkUser.equals(null)){
			System.out.println(checkUser.getEmail() + " inside null");
			jsonObject.append("status", 401);
			System.out.println(jsonObject.toString() + " inside null");
			return jsonObject.toString();
		}else{
			if(checkUser.getPassword() == password && user.getStatus() == 1){
				System.out.println(checkUser.getEmail() + " inside authenticated");
				jsonObject.append("status", 200);
				jsonObject.append("loginStatus","authenticated" + " inside authenticated");
				System.out.println(jsonObject.toString());
				return jsonObject.toString();
			}else if(checkUser.getPassword() == password && user.getStatus() == 0){
				System.out.println(checkUser.getEmail() + " inside not authenticated");
				jsonObject.append("status", 201);
				jsonObject.append("loginStatus", "notAuthtenticated" );
				System.out.println(jsonObject.toString() + " inside not authenticated");
				return jsonObject.toString();
			}else{
				System.out.println(checkUser.getEmail() + " error condition");
				jsonObject.append("status", 400);
				System.out.println(jsonObject.toString() + " error condition");
				return jsonObject.toString();
			}
		}
		
	}
	
}
