package com.likelion.backend.domain.category.service;

import com.likelion.backend.domain.category.dto.CategoryRequest;
import com.likelion.backend.domain.category.dto.CategoryResponse;
import com.likelion.backend.domain.category.entity.Category;
import com.likelion.backend.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = new Category(request.getName());
        Category savedCategory = categoryRepository.save(category);

        return CategoryResponse.from(savedCategory);
    }

    public List<CategoryResponse> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponse::from)
                .toList();
    }
}
