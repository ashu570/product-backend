package com.niit.demobackend.service;

import com.niit.demobackend.data.Data;
import com.niit.demobackend.model.LoginCred;
import com.niit.demobackend.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    Data data;
    @Override
    public User addUser(User user) {
        if(!data.getUsers().containsKey(user.getEmail()))
        {
            data.addData(user);
            return user;
        }
        throw  new RuntimeException("Bad request");
    }

    @Override
    public User login(LoginCred user) throws IOException {
        if(data.getUsers().containsKey(user.getEmail())){
            if(data.getUsers().get(user.getEmail()).getPassword().equals(user.getPassword()))
            {
                return data.getUsers().get(user.getEmail());
            }
        }
        return null;
    }
}
