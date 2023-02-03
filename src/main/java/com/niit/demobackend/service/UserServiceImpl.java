package com.niit.demobackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.demobackend.data.Data;
import com.niit.demobackend.model.LoginCred;
import com.niit.demobackend.model.User;
import com.niit.demobackend.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepo userRepo;
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
