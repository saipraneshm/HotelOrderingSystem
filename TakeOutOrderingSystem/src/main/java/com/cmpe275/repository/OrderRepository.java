package com.cmpe275.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.cmpe275.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {



}
