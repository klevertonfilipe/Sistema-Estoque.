package com.example.inventory.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_CATEGORY")
public class CategoryModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long idCategory;

    @NotBlank
    private String categoryName;

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public @NotBlank String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(@NotBlank String categoryName) {
        this.categoryName = categoryName;
    }
}


