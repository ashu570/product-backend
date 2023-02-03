package com.niit.demobackend.controller;

import com.niit.demobackend.model.Product;
import com.niit.demobackend.service.ProductService;
import com.niit.demobackend.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    ProductServiceImpl productService;
//    @CrossOrigin
//    @GetMapping("/product/{id}")
//    public ResponseEntity<?> getProd(@PathVariable long id){
//        try{
//            Product product = productService.getProduct(id);
//            if(product!=null)
//                return new ResponseEntity<>(product, HttpStatus.OK);
//        }catch (Exception exception){
//            System.out.println(exception.getMessage());
//        }
//        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
//    }
    @CrossOrigin
    @GetMapping(value = "/products",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllProds(){
        try{
            StringBuilder product = productService.getAllProducts();
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }

//    @PostMapping(value = "/product/bulk",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> addAllProds(@RequestBody List<Product> products){
//        try{
//            List<Product> product = productService.addBulk(products);
//            if(product.size()>0)
//                return new ResponseEntity<>(product, HttpStatus.OK);
//        }catch (Exception exception){
//            System.out.println(exception.getMessage());
//        }
//        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
//    }
    @PostMapping("/product")
    public ResponseEntity<?> addProd(@RequestBody Product products){
        try{
            Product product = productService.addProduct(products);
            if(product!=null)
                return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }
}
