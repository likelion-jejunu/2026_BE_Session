package com.likelion.backend.domain.category.controller;

import com.likelion.backend.domain.category.dto.CategoryRequest;
import com.likelion.backend.domain.category.dto.CategoryResponse;
import com.likelion.backend.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @GetMapping
    public List<CategoryResponse> getCategories() {
        return categoryService.getCategories();
    }
}
