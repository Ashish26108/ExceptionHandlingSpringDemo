package org.example.techie.exceptionhandlingspringbootdemo.controller;


import jakarta.validation.Valid;
import org.example.techie.exceptionhandlingspringbootdemo.entity.User;
import org.example.techie.exceptionhandlingspringbootdemo.exception.UserNotFoundException;
import org.example.techie.exceptionhandlingspringbootdemo.repository.UserRepository;
import org.example.techie.exceptionhandlingspringbootdemo.repository.orderRepository;
import org.example.techie.exceptionhandlingspringbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
//
//    @PostMapping("/createUser")
//    public ResponseEntity<User> saveUser(@RequestBody @Valid User user){
//        userService.saveUser(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//
//}
     @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
         return ResponseEntity.ok(userService.getUser(id));
     }

    @GetMapping(produces= {"application/json","application/xml"})  //add dependency for xml(content negotiation)
    @ResponseBody
     public List<User> getAllUsers(){

         return userService.getAllUsers();
     }

     //http://localhost:9191/user/sorting?field=name
    @GetMapping(value="/sorting",produces= {"application/json","application/xml"})  //add dependency for xml(content negotiation)
    @ResponseBody
    public List<User> getUsersWithSorting(@RequestParam String field){
        return userService.getUsersWithSorting(field);
    }




}
