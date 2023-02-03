package com.niit.demobackend.repository;

import com.niit.demobackend.model.Product;
import com.niit.demobackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User getUserByEmail(String email);
}
