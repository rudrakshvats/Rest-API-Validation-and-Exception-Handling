package com.rudraksh.validation.service;

import com.rudraksh.validation.dto.UserRequest;
import com.rudraksh.validation.entity.User;
import com.rudraksh.validation.exception.UserNotFoundException;
import com.rudraksh.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
                userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int userId) throws UserNotFoundException {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            return user;
        }
        else{
            throw new UserNotFoundException("No user found for the user id: " + userId);
        }
    }
}
