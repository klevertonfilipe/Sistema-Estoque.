package com.example.inventory.config;

import com.example.inventory.entities.SplayTree;
import com.example.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final ProductRepository productRepository;
    private SplayTree splayTreeInstance = null;

    @Autowired
    public AppConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public SplayTree splayTree() {
        if (splayTreeInstance == null) {
            SplayTree splayTree = new SplayTree();
            productRepository.findAll().forEach(splayTree::insert); // mesma coisa de : productRepository.findAll().forEach(product -> splayTree.insert(product));
            splayTreeInstance = splayTree;
        }
        return splayTreeInstance;
    }
}
