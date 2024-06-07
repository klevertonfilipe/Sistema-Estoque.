package com.example.inventory.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoryRecordDto(@NotBlank String categoryName) {


    @Override
    public String toString() {
        return "CategoryRecordDto{" +
                "name='" + categoryName + '\'' +
                '}';
    }
}
