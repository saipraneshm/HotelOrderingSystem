package com.cmpe275.controllers;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmpe275.domain.User;
import com.cmpe275.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
    public List<User> registerUser() {
        
		User user = new User("sai","pranesh");
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

}
