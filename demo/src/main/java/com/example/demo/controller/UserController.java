package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.demo.Models.User;
import com.example.demo.services.UserServices;

/*Rest controller tells Stringboot this class will handle API requests */
@RestController
@RequestMapping("/api/users") // sets the base url for all endpoints inside this class

public class UserController {
    
/*
 * annotation is used for dependency injection.
 *  It tells Spring to automatically create and inject an instance of a class 
 */
    @Autowired
    private UserServices userServices; // injecting an instance of userServices here

    
    /*
    Get mapping maps a http get request to the method its applied to
     * when a client sends a GET request to /api/users/all
     * this mehtod is called and it returns a list of all users
     */
    @GetMapping("/all")
    public List<User>getAllUsers(){
       return userServices.getAllUsers();
    }
    @GetMapping
public List<User> getUsers() {
    return userServices.getAllUsers();
}

    /*
     * When a client sends a get requests to /api/user/{username}
     * this method is called and returns the specified user    
     * */
    @GetMapping("/{username}")
    public User getUserbyUsername(@PathVariable String username){
        // @pathvarible . This annotation binds a variable from the URL path to a method parameter.
        return userServices.getUserByUsername(username);
    }

    /*
     * A post request sends data to the server to create or update a resource
     * when you use @postmapping it tells sprinboot you are handling a post requst
     */
    @PostMapping
    public User createUser(@RequestBody User user){
        //@requestbody binds the json data to a varible/user object
        return userServices.createUser(user);
    }
}
