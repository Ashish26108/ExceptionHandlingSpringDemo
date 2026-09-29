package org.example.techie.exceptionhandlingspringbootdemo.controller;

import org.example.techie.exceptionhandlingspringbootdemo.entity.Order;
import org.example.techie.exceptionhandlingspringbootdemo.exception.categoryNotFoundException;
import org.example.techie.exceptionhandlingspringbootdemo.repository.orderRepository;
import org.example.techie.exceptionhandlingspringbootdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class ProductContoller {

    @Autowired
    private orderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping(produces= {"application/json","application/xml"})  //add dependency for xml(content negotiation)
    @ResponseBody
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Order> getOrdersByCategory(@PathVariable String category) throws categoryNotFoundException {
        return (List<Order>) ResponseEntity.ok(orderService.getOrdersByCategory(category));

}}
