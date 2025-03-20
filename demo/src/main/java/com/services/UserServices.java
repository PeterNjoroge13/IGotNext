package com.services;
import org.springframework.stereotype.Service;
import com.Models.User;
import com.repository.UserRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired; // Helps inject dependencies


// creating a Java class that controls how users are retrieved, saved, or searched for.

//service tells springboot this is a sercivce which handles busness logics
@Service
public class UserServices {
 /* This tells Spring Boot: "Automatically create an instance of UserRepository for me!"
    - Dont forget the UserReposity is a connection between the user entity and the databas
 */  

    @Autowired 
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        /*
         * find all is a build in method that runs the SQL QUREY selct * from USERS
         * returns a list of all users in the database
         */
        return userRepository.findAll();
    }
    public User getUserByUsername(String username){
        /*
         * Calling the function we implemented in the userRepository class to get 
         * user associated by the string username
         */
       return userRepository.findByUsername(username);
    }
    public User createUser(User user){
        /*
         * This method automatiically creates a new user into the MySQL
         */
        return userRepository.save(user);
    }


}
