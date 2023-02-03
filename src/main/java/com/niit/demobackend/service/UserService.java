package com.niit.demobackend.service;

import com.niit.demobackend.model.LoginCred;
import com.niit.demobackend.model.User;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserService {
    User addUser(User user);
    User login(LoginCred user) throws IOException;

}
