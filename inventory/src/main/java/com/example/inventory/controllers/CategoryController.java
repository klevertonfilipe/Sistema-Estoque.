package com.example.inventory.controllers;

import com.example.inventory.dtos.CategoryRecordDto;
import com.example.inventory.models.CategoryModel;
import com.example.inventory.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // Adicione este método para lidar com a requisição do favicon.ico
    @RequestMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }

    @PostMapping("/categoria")
    public String saveCategory(@Valid CategoryRecordDto categoryRecordDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "redirect:/categorias";
        }
        System.out.println(categoryRecordDto.toString());
        var categoryModel = new CategoryModel();
        BeanUtils.copyProperties(categoryRecordDto, categoryModel);
        categoryRepository.save(categoryModel);
        System.out.println("OK");
        return "redirect:/categorias";
    }

    @DeleteMapping("/categoria/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        Optional<CategoryModel> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent()) {
            System.out.println("Categoria não encontrada");
            return "redirect:/categorias";
        }
        CategoryModel categoria = categoryOptional.get();
        categoryRepository.delete(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("editarCategoria/{id}")
    public String editCategory(@PathVariable("id") long id, Model model) {
        Optional<CategoryModel> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent()) {
            System.out.println("Categoria não encontrada");
            return "redirect:/categorias";
        }
        CategoryModel categoryModel = categoryOptional.get();
        model.addAttribute("categoria", categoryModel);
        return "editarCategoria";
    }

    @PutMapping("categoria/{id}")
    public String updateCategory(@PathVariable("id") long id, @Valid CategoryRecordDto categoryRecordDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:/editarCategoria/" + id;
        }
        Optional<CategoryModel> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent()) {
            System.out.println("Categoria não encontrada");
            return "redirect:/categorias";
        }
        CategoryModel categoryModel = categoryOptional.get();
        BeanUtils.copyProperties(categoryRecordDto, categoryModel);
        System.out.println(categoryModel.toString());
        categoryRepository.save(categoryModel);
        return "redirect:/categorias";
    }
}
