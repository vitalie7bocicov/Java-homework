package com.controller;

import com.dao.UserDAO;
import java.sql.SQLException;
import java.util.List;
import com.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vital
 */
@RestController
@CrossOrigin
@RequestMapping({"/users"})
public class UserController {

    private List<User> users;
    private UserDAO userUtil = new UserDAO();

    @GetMapping
    public List<User> getUsers() throws SQLException {
        users = userUtil.findAll();
        return users;
    }

    @GetMapping("/{name}")
    public User getUser(@PathVariable("name") String name) throws SQLException {
        User user = userUtil.findByName(name);
        System.out.println("user:" + user.getName());
        return user;

    }

    @PostMapping
    public User createUser(@RequestParam String name) throws SQLException {
        User user = new User(name);
        userUtil.create(user);
        return userUtil.findByName(user.getName());
    }

    @PostMapping(value = "/obj", consumes = "application/json")
    public ResponseEntity<String>
            createUser(@RequestBody User user) throws SQLException {
        userUtil.create(user);
        return new ResponseEntity<>(
                "User created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable int id, @RequestParam String name) throws SQLException {
        if (userUtil.findById(id) == null) {
            return new ResponseEntity<>(
                    "User not found", HttpStatus.NOT_FOUND); //or GONE
        }
        userUtil.updateName(id, name);

        return new ResponseEntity<>(
                "Product updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) throws SQLException {
        if (userUtil.findById(id) == null) {
            return new ResponseEntity<>(
                    "User not found", HttpStatus.NOT_FOUND); //or GONE
        }
        userUtil.delete(id);
        return new ResponseEntity<>("User removed", HttpStatus.OK);
    }

}
