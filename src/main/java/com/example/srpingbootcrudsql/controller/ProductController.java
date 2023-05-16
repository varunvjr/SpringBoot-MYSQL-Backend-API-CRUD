package com.example.srpingbootcrudsql.controller;

import com.example.srpingbootcrudsql.entity.Product;
import com.example.srpingbootcrudsql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }
    @GetMapping("/getProducts")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/getProductById/{id}")
    public Optional<Product> findProductById(@PathVariable int id){
        return productService.getProduct(id);
    }
    @GetMapping("getProductByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}
