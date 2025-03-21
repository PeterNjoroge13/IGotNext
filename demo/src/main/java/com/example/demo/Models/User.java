package com.example.demo.Models;

import jakarta.persistence.*;

@Entity // This tells springboot this repsresents a table in the database 
@Table(name = "users") // Specifies the table name in the database
 public class User { 

    /* TLDR: *ID is unique identifier for each user in the database.
        each row has an unique ID number. 
        We are making in gen automatically when user is created.
         ID # links to row in the table */
     
@Id //tells Spring this field is the primary key // Automatically generates the ID when a new user is added to the database
@GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

private String username;
 private String email; 
 //No getter for password for priv reasons, supress the yellow line 
 @SuppressWarnings("unused") 
 private String password;


    // Normal getters and setters
    public Long getId() {
        return id;
    }
public void setID(Long iden){
    id = iden;
}
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
}