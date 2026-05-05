package com.example.course.repositories;

import com.example.course.entities.Order;
import com.example.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
