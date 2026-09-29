package org.example.techie.exceptionhandlingspringbootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.example.techie.exceptionhandlingspringbootdemo.entity.Order;
import org.example.techie.exceptionhandlingspringbootdemo.entity.User;
import org.example.techie.exceptionhandlingspringbootdemo.exception.UserNotFoundException;
import org.example.techie.exceptionhandlingspringbootdemo.exception.categoryNotFoundException;
import org.example.techie.exceptionhandlingspringbootdemo.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {

    @Autowired
    orderRepository repository;

    public List<Order> getOrdersByCategory( String category) throws categoryNotFoundException {
          List<Order> order= repository.findByCategory(category);
//          System.out.println(order.isEmpty());
//          if(order.isEmpty()){
//              throw new categoryNotFoundException("CategoryNotFound");
//          }
//          return order;

//        log.info("******Order*****"+order);
        List<Order> collectOrder = order.stream().filter(o -> o.getCategory().equals(category)).collect(Collectors.toList());
       // return collect.orElseThrow(()-> new categoryNotFoundException("CategoryNotFound"));
        return Optional.of(collectOrder).filter(list->!list.isEmpty())
                .orElseThrow(()-> new categoryNotFoundException("CategoryNotFound"));
    }


}
