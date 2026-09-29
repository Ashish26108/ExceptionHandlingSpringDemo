package org.example.techie.exceptionhandlingspringbootdemo.service;

import org.example.techie.exceptionhandlingspringbootdemo.entity.User;
import org.example.techie.exceptionhandlingspringbootdemo.exception.UserNotFoundException;
import org.example.techie.exceptionhandlingspringbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//    public User saveUser(User user) {
//        User usr = new User(0,user.getName(),user.getEmail(),user.getPhoneNumber());
//        return userRepository.save(usr);
//    }

    public User getUser(int id) throws UserNotFoundException {
        Optional<User> user=userRepository.findById(id);

//        Optional<String> name= Optional.ofNullable(user.get().getName());
//        if(name.isPresent()){
//            System.out.println("****NAme**** "+name.get());
//        }else{
//            System.out.println("****NAme Not found**** ");
//        }

        return user.orElseThrow(()-> new UserNotFoundException("User not present with id "+id));


    }

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }




    public List<User> getUsersWithSorting(String field){
        return userRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }
}
