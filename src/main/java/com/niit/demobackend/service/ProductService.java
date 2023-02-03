package com.niit.demobackend.service;

import com.niit.demobackend.model.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product addProduct(Product product) throws IOException;
//    List<Product> addBulk(List<Product> products);
    Long deleteProduct(long id);
//    Product getProduct(long id);
    StringBuilder getAllProducts() throws IOException;
    Product updateProduct(long id);
}
