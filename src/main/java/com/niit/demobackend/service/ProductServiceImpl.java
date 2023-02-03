package com.niit.demobackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.demobackend.model.Product;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements  ProductService{
    @Override
    public Product addProduct(Product product) throws IOException {
        JSONArray jsonArray = new JSONArray(getAllProducts().toString());
        jsonArray.put(product);
        new ObjectMapper().writeValue(new File("data.json"),jsonArray.toList());
        return product;
    }

//    @Override
//    public List<Product> addBulk(List<Product> products) {
//        return productRepo.saveAll(products);
//    }

    @Override
    public Long deleteProduct(long id) {
        return null;
    }

//    @Override
//    public Product getProduct(long id) {
//        return productRepo.findById(id).get();
//    }

    @Override
    public StringBuilder getAllProducts() throws IOException {
        try(InputStream stream = new FileInputStream(new File("data.json"))){
            StringBuilder data=new StringBuilder();
            while (stream.available()>0){
                data.append((char) stream.read());
            }
            return data;
        }
    }

    @Override
    public Product updateProduct(long id) {
        return null;
    }
}
