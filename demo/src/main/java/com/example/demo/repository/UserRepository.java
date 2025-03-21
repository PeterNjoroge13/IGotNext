package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.User;

/*
 * This interface acts as a bridge between the User entity and the database.
 * It provides built-in methods for common database operations like save, find,
 * update, and delete.
 * 
 * extends JpaRepository<User, Long> → This tells Spring Boot:
 * "Hey, this is a repository for the User table, and the id is a Long number."
 * 
 * How it works:
 * - The method findByUsername(String username) is a custom query method. Spring generates
 *   the SQL query automatically based on the method name. For example:
 *   "SELECT * FROM users WHERE username = ?"
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method to find a user by their username
    User findByUsername(String username);
}