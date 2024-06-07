package com.example.inventory.dtos;

import com.example.inventory.models.CategoryModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductRecordDto(
        @NotBlank String name,
        @NotNull BigDecimal price,
        @NotNull String description,
        @NotNull Long quantity,
        @NotNull(message = "a Categoria é obrigatória") CategoryModel categoryId
) {
    @Override
    public String toString() {
        return "ProductRecordDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", categoryId=" + categoryId +
                '}';
    }




    public CategoryModel getCategoryId() {
        return categoryId;
    }
    public Long getQuantity() {
        return quantity;
    }

}


