package com.example.demo.Product.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private Double price;

    //Create the DTO
    public ProductDTO(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
    public ProductDTO(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
