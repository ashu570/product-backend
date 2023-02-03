package com.niit.demobackend.controller;

import com.niit.demobackend.model.LoginCred;
import com.niit.demobackend.model.User;
import com.niit.demobackend.repository.UserRepo;
import com.niit.demobackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {
            userService.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginCred user){
        try {
            User validUser = userService.login(user);
            if(validUser!=null) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }catch (Exception exception){}
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
