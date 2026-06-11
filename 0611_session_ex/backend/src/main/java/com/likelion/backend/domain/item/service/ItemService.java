package com.likelion.backend.domain.item.service;

import com.likelion.backend.domain.category.entity.Category;
import com.likelion.backend.domain.category.repository.CategoryRepository;
import com.likelion.backend.domain.item.dto.ItemRequest;
import com.likelion.backend.domain.item.dto.ItemResponse;
import com.likelion.backend.domain.item.entity.Item;
import com.likelion.backend.domain.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public ItemResponse createItem(ItemRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("카테고리를 찾을 수 없습니다."));

        Item item = new Item(
                request.getItemName(),
                request.getPrice(),
                request.getQuantity(),
                category
        );

        Item savedItem = itemRepository.save(item);

        return ItemResponse.from(savedItem);
    }

    public List<ItemResponse> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponse::from)
                .toList();
    }
}
