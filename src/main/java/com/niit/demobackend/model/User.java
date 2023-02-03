package com.niit.demobackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
public class User {
    private long id;
    private String name;
    private String email;
    private String password;
}
