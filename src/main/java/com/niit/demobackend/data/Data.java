package com.niit.demobackend.data;

import com.niit.demobackend.model.LoginCred;
import com.niit.demobackend.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@Setter
public class Data {
    private  Map<String,User> users = new HashMap<>();

    public void addData(User user){
        this.users.put(user.getEmail(),user);
    }
}
