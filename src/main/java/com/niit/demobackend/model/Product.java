package com.niit.demobackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private String model;
    private Double price;
    private Double rating;
    private String image;
}
