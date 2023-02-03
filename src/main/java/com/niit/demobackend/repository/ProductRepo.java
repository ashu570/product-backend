package com.niit.demobackend.repository;

import com.niit.demobackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepo extends JpaRepository<Product,Long> {
}
