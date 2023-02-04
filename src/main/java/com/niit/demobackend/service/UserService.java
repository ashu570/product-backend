package com.niit.demobackend.service;

import com.niit.demobackend.model.LoginCred;
import com.niit.demobackend.model.User;

import java.io.IOException;

public interface UserService {
    String addUser(User user) throws IOException;
    String login(LoginCred user) throws IOException;

}
