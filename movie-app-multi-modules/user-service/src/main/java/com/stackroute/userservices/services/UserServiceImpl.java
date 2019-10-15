package com.stackroute.userservices.services;

import com.stackroute.userservices.domain.User;
import com.stackroute.userservices.exceptions.UserAlreadyExistsException;
import com.stackroute.userservices.exceptions.UserException;
import com.stackroute.userservices.exceptions.UserNotFoundException;
import com.stackroute.userservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserException {
        if(userRepository.existsById(user.getId()))
            throw new UserAlreadyExistsException("saveUser(): User[id="+user.getId()+"] already exists in database");
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(int id) throws UserException {
        if(!userRepository.existsById(id))
            throw new UserNotFoundException("deleteUser(): User[id="+id+"] does not exist in database");
        User user = getUser(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) throws UserException {
        if(!userRepository.existsById(id))
            throw new UserNotFoundException("getUser(): User[id="+id+"] does not exist in database");
        return userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) throws UserException {
        if(!userRepository.existsById(user.getId()))
            throw new UserNotFoundException("updateUser(): User[id="+user.getId()+"] does not exist in database");
        User newUser = userRepository.findById(user.getId()).get();
        if(user.getName() != null){
            newUser.setName(user.getName());
        }
        if(user.getPassword() != null){
            newUser.setPassword(user.getPassword());
        }
        if(user.getAge() != 0){
            newUser.setAge(user.getAge());
        }
        if(user.getGender() != null){
            newUser.setGender(user.getGender());
        }

        userRepository.save(newUser);
        return newUser;
    }
}
