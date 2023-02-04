package com.niit.demobackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.demobackend.data.Data;
import com.niit.demobackend.model.LoginCred;
import com.niit.demobackend.model.User;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    Data data;
    @Override
    public String addUser(User user) throws IOException {
        JSONArray jsonArray = new JSONArray(getUsers().toString());
        for (int index = 0; index < jsonArray.length(); index++) {
            JSONObject obj =  (JSONObject) jsonArray.get(index);
            if(((JSONObject) jsonArray.get(index)).getString("email").equals(user.getEmail())){
                throw  new RuntimeException("Bad request");
            }
        }
        try(FileWriter os = new FileWriter(new File("user.json"))) {
            jsonArray.put(user);
            new ObjectMapper().writeValue(os,jsonArray.toList());
            return ","+new ObjectMapper().writeValueAsString(user);
        }
    }

    @Override
    public String login(LoginCred user) throws IOException {
        JSONArray jsonArray = new JSONArray(getUsers().toString());
        for (int index = 0; index < jsonArray.length(); index++) {
            JSONObject obj =  (JSONObject) jsonArray.get(index);
            if(obj.getString("email").equals(user.getEmail())){
                if(obj.getString("password").equals(user.getPassword()))
                {
                    return  new ObjectMapper().writeValueAsString(obj);
                }
            }
        }
        return null;
    }

    private StringBuilder getUsers() throws IOException {
        StringBuilder users= new StringBuilder();
        try(InputStream fs = new FileInputStream("user.json")){
            while (fs.available()>0){
                users.append((char) fs.read());
            }
        };
        return users;
    }

}
