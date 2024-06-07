package com.example.inventory.controllers;
import com.example.inventory.entities.SplayTree;
import com.example.inventory.models.CategoryModel;
import com.example.inventory.models.ProductModel;
import com.example.inventory.repositories.CategoryRepository;
import com.example.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class WebController {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SplayTree splayTree;

    @Autowired
    public WebController(ProductRepository productRepository, CategoryRepository categoryRepository, SplayTree splayTree) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.splayTree = splayTree;
    }



    @GetMapping("/")
    public String index(Model model) {
        List<CategoryModel> categories = categoryRepository.findAll();
        model.addAttribute("splayTree", splayTree);
        model.addAttribute("categories", categories);
        return "index";
    }


    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        List<CategoryModel> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "cadastrarProduto";
    }

    @GetMapping("/saiba-mais")
    public String saibaMais() {
        return "saiba-mais";
    }

    @GetMapping("/categorias")
    public String categorias(Model model) {
        List<CategoryModel> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categorias";
    }



    @GetMapping("/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model) {
        // Busca o produto pelo ID
        System.out.println("aqui é o ID: "+ id);
        Optional<ProductModel> produtoOptional = productRepository.findById(id);
        ProductModel produto = produtoOptional.get();
        model.addAttribute("produto", produto);
        List<CategoryModel> categoria = categoryRepository.findAll();
        model.addAttribute("categories", categoria);

        return "editarProduto";
    }







}












