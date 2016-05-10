package com.cmpe275.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cmpe275.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	List<User> findByUserIdLessThan(int value);
	List<User> findByLastnameAndFirstname(String lastname, String firstname);
	User findByEmail(String email);

}
