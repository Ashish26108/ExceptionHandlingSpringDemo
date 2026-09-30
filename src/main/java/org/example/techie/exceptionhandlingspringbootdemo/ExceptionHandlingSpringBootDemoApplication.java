package org.example.techie.exceptionhandlingspringbootdemo;

import jakarta.annotation.PostConstruct;
import org.example.techie.exceptionhandlingspringbootdemo.entity.Order;
import org.example.techie.exceptionhandlingspringbootdemo.entity.User;
import org.example.techie.exceptionhandlingspringbootdemo.repository.UserRepository;
import org.example.techie.exceptionhandlingspringbootdemo.repository.orderRepository;
import org.example.techie.exceptionhandlingspringbootdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ExceptionHandlingSpringBootDemoApplication {

    @Autowired
    private orderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;
//
//    @PostConstruct
//    public void initOrdersTable() {
//        orderRepository.saveAll(Stream.of(
//                        new Order("mobile", "electronics", "white", 20000),
//                        new Order("T-Shirt", "clothes", "black", 999),
//                        new Order("Jeans", "clothes", "blue", 1999),
//                        new Order("Laptop", "electronics", "gray", 50000),
//                        new Order("digital watch", "electronics", "black", 2500),
//                        new Order("Fan", "electronics", "black", 50000)
//                ).
//                collect(Collectors.toList()));
//    }

    @PostConstruct
    public void inituserTable() {
        userRepository.saveAll(Stream.of(
                        new User(187,"ka","ka@gmail.com","9099393939",23),
                        new User(123,"po","po@gmail.com","9099393931",78),
                        new User(131,"tr","tr@gmail.com","9099393938",45),
                        new User(143,"uy","uy@gmail.com","9099393988",34),
                        new User(234,"ab","ab@gmail.com","9099393930",53),
                        new User(211,"bh","bh@gmail.com","9099393946",67),
                        new User(289,"cg","cg@gmail.com","9099393956",27),
                        new User(145,"nj","nj@gmail.com","9099393998",56),
                        new User(167,"mj","mj@gmail.com","9099393923",69),
                        new User(190,"kj","kj@gmail.com","9099393999",72),
                        new User(345,"lk","lk@gmail.com","9099393974",45),
                        new User(389,"op","op@gmail.com","9099393895",54),
                        new User(355,"iu","iu@gmail.com","9099387939",59),
                        new User(450,"uu","uu@gmail.com","9099567939",47),
                        new User(451,"vv","vv@gmail.com","90995677839",47),
                        new User(451,"zz","zz@gmail.com","9099567678",77)

                ).
                collect(Collectors.toList()));
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx=SpringApplication.run(ExceptionHandlingSpringBootDemoApplication.class, args);
        OrderService bean=ctx.getBean(OrderService.class);
        System.out.println("************Bean******* "+bean);
    }

}
