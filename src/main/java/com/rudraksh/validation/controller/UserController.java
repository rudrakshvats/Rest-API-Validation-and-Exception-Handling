package com.rudraksh.validation.controller;

import com.rudraksh.validation.dto.UserRequest;
import com.rudraksh.validation.entity.User;
import com.rudraksh.validation.exception.UserNotFoundException;
import com.rudraksh.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    /* the variable userId will be dynamically passed inside the url (eg: /users/310182) in our url by the
    use of @PathVariable annotation which helps us in passing the variable in our path
     */
    public ResponseEntity<User> getUser(@PathVariable int userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
