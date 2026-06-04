package com.likelion.itemapi.dto;

import com.likelion.itemapi.domain.Item;
import lombok.Getter;
import lombok.Setter;

/**
 * ItemRequest (요청 DTO)
 *
 * 클라이언트가 보낸 JSON 데이터를 받는 객체이다.
 * Controller의 @RequestBody와 함께 사용된다.
 *
 * JSON의 키 이름과 필드명이 일치해야 자동으로 매핑된다.
 *
 * 예시)
 * {
 *   "itemName": "키보드",
 *   "price": 89000,
 *   "quantity": 30
 * }
 */
@Getter
@Setter
public class ItemRequest {

    // 상품명
    private String itemName;

    // 가격
    private Integer price;

    // 수량
    private Integer quantity;

    /**
     * DTO -> Entity 변환
     *
     * Controller에서 받은 요청 데이터를
     * 실제 비즈니스 객체(Item)로 변환한다.
     */
    public Item toEntity() {
        return new Item(this.itemName, this.price, this.quantity);
    }
}