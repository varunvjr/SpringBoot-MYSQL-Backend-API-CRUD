package com.example.srpingbootcrudsql.service;

import com.example.srpingbootcrudsql.entity.Product;
import com.example.srpingbootcrudsql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public Product saveProduct(Product product){
       return  repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Optional<Product> getProduct(int id){
        return repository.findById(id);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed :"+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice((product.getPrice()));
        existingProduct.setQuantity((product.getQuantity()));
        return repository.save(existingProduct);

    }

}
