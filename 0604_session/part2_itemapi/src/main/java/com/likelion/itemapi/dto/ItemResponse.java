package com.likelion.itemapi.dto;

import com.likelion.itemapi.domain.Item;
import lombok.Getter;

/**
 * ItemResponse (응답 DTO)
 *
 * 서버가 클라이언트에게 응답할 데이터를 담는 객체이다.
 * Entity 전체를 그대로 반환하지 않고,
 * 필요한 데이터만 골라서 전달하기 위해 사용한다.
 *
 * @Getter가 있어야 Jackson이 값을 읽어 JSON으로 변환할 수 있다.
 * Getter가 없으면 응답이 {} 형태로 비어 보일 수 있다.
 */
@Getter
public class ItemResponse {

    // 상품 번호
    private final Long id;

    // 상품명
    private final String itemName;

    // 가격
    private final Integer price;

    // 수량
    private final Integer quantity;

    /**
     * Entity -> Response DTO 변환 생성자
     *
     * Item 객체의 값을 꺼내서
     * 응답용 DTO에 복사한다.
     */
    public ItemResponse(Item item) {
        this.id = item.getId();
        this.itemName = item.getItemName();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
    }

    /**
     * Entity를 Response DTO로 변환하는 편의 메서드
     *
     * 사용 예시:
     * ItemResponse response = ItemResponse.from(item);
     */
    public static ItemResponse from(Item item) {
        return new ItemResponse(item);
    }
}