package org.example.techie.exceptionhandlingspringbootdemo.repository;

import org.example.techie.exceptionhandlingspringbootdemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface orderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCategory(String category);
}
