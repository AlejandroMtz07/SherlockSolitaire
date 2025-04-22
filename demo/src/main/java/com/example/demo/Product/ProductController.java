package com.example.demo.Product;


import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDTO;
import com.example.demo.Product.Model.UpdateProductCommnad;
import com.example.demo.Product.commandHandlers.CreateProductCommandHandler;
import com.example.demo.Product.commandHandlers.DeleteProductCommandHandler;
import com.example.demo.Product.commandHandlers.UpdateProductCommandHandler;
import com.example.demo.Product.queryhandlers.GetAllProductsQueryHandler;
import com.example.demo.Product.queryhandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //Dependency injection
    //Bean
    //Field injection

    @Autowired private ProductRepository productRepository;

    @Autowired private GetAllProductsQueryHandler getAllProductsQueryHandler;

    @Autowired private GetProductQueryHandler getProductQueryHandler;

    @Autowired private CreateProductCommandHandler createProductCommandHandler;

    @Autowired private UpdateProductCommandHandler updateProductCommandHandler;

    @Autowired private DeleteProductCommandHandler deleteProductCommandHandler;



    @GetMapping("/search/{maxPrice}")
    public ResponseEntity<List<Product>> findProductByPrice(@PathVariable Double maxPrice) {
        return ResponseEntity.ok(productRepository.findProductsWithPriceLessThan(maxPrice));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        //Method that get every single entry in all table
        return getAllProductsQueryHandler.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id) {
        return getProductQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        return createProductCommandHandler.execute(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        //We get the id in the URL of the request and set the values passed by the body of the request
        UpdateProductCommnad command = new UpdateProductCommnad(id, product);
        return updateProductCommandHandler.execute(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        return deleteProductCommandHandler.execute(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(value="description") String description) {
        return ResponseEntity.ok(productRepository.findByDescriptionContaining(description));
    }

}
