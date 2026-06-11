package com.likelion.backend.domain.item.dto;

import com.likelion.backend.domain.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemResponse {

    private Long id;

    private String itemName;

    private int price;

    private int quantity;

    private Long categoryId;

    private String categoryName;

    public static ItemResponse from(Item item) {
        return new ItemResponse(
                item.getId(),
                item.getItemName(),
                item.getPrice(),
                item.getQuantity(),
                item.getCategory().getId(),
                item.getCategory().getName()
        );
    }
}