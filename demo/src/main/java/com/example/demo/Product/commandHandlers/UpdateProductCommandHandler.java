package com.example.demo.Product.commandHandlers;


import com.example.demo.Command;
import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.UpdateProductCommnad;
import com.example.demo.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//The first element is the element we're going to receive, and the second is the one we are going to return
public class UpdateProductCommandHandler implements Command<UpdateProductCommnad, ResponseEntity> {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<ResponseEntity> execute(UpdateProductCommnad command) {
        Optional<Product> optionalProduct = productRepository.findById(command.getId());
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException();
        }
        Product product = command.getProduct();

        product.setId(command.getId());
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}
