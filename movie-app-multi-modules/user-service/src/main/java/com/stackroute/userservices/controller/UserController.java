package com.stackroute.userservices.controller;

import com.stackroute.userservices.domain.User;
import com.stackroute.userservices.exceptions.UserException;
import com.stackroute.userservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {

    private UserService userService;

    public UserController() {

    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserException {
        System.out.println("saveMovie(): " + user.toString());
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws UserException {
        System.out.println("deleteUser(): id = " + id);
        return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.OK);
    }

    @GetMapping(value = "users")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) throws UserException {
        return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
    }

    @PutMapping(value = "movie")
    public ResponseEntity<?> updateUser(@RequestBody User user) throws UserException {
        System.out.println("updateUser(): " + user.toString());
        return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
    }
}
