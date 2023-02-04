package com.niit.demobackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
public class User {
    private String name;
    private String email;
    private String password;
}
