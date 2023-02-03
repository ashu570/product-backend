package com.niit.demobackend.model;
import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private String model;
    private Double price;
    private Double rating;
    private String image;
}
