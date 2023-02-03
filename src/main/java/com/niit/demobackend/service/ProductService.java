package com.niit.demobackend.service;

import com.niit.demobackend.model.Product;

import java.io.IOException;

public interface ProductService {
    Product addProduct(Product product) throws IOException;
//    List<Product> addBulk(List<Product> products);
    Long deleteProduct(long id);
    String getProduct(long id) throws IOException;
    StringBuilder getAllProducts() throws IOException;
    Product updateProduct(long id);
}
