package com.likelion.itemapi.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Item(Entity)
 *
 * 상품 한 개를 표현하는 객체이다.
 * 상품의 상태(데이터)만 가지고 있으며,
 * 비즈니스 로직은 포함하지 않는다.
 */
@Getter
@Setter
public class Item {

    // 상품을 구분하기 위한 고유 번호
    // 저장할 때 Repository가 자동으로 부여한다.
    private Long id;

    // 상품 이름
    private String itemName;

    // 상품 가격
    private Integer price;

    // 상품 재고 수량
    private Integer quantity;

    /**
     * 기본 생성자
     *
     * Spring이나 Jackson이 JSON 데이터를 객체로 변환할 때 사용한다.
     */
    public Item() {
    }

    /**
     * 상품 등록용 생성자
     *
     * 상품명, 가격, 수량만 받아서 객체를 생성한다.
     * id는 저장 시 Repository가 자동으로 부여한다.
     */
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}