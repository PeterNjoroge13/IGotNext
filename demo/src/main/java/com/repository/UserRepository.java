package com.repository;

import com.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * This interface acts as a bridge between the User entity and the database.
 * It provides built-in methods for common database operations like save, find,
 * update, and delete.
 * 
 * extends JpaRepository<User, Long> → This tells Spring Boot:
 * "Hey, this is a repository for the User table, and the id is a Long number."
 * 
 * How it works:
 * - Spring Boot automatically creates an implementation of this interface at runtime.
 * - The JpaRepository<User, Long> tells Spring that this repository is for the User entity,
 *   and the primary key (id) is of type Long.
 * - The method findByUsername(String username) is a custom query method. Spring generates
 *   the SQL query automatically based on the method name. For example:
 *   "SELECT * FROM users WHERE username = ?"
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method to find a user by their username
    User findByUsername(String username);
}