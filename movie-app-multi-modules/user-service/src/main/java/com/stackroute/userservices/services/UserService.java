package com.stackroute.userservices.services;

import com.stackroute.userservices.domain.User;
import com.stackroute.userservices.exceptions.UserException;

import java.util.List;

public interface UserService {
    public User saveUser(User User) throws UserException;
    public User deleteUser(int id) throws UserException;
    public List<User> getAllUsers();
    public User getUser(int id) throws UserException;
    public User updateUser(User User)throws UserException;
}
