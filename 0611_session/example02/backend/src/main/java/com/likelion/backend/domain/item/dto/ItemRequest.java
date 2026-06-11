package com.likelion.backend.domain.item.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemRequest {

    private String itemName;

    private int price;

    private int quantity;

    private Long categoryId;
}