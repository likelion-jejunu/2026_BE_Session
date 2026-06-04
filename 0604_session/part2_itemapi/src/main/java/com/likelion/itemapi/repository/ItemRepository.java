package com.likelion.itemapi.repository;

import com.likelion.itemapi.domain.Item;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repository
 * 데이터를 저장하고 조회하는 역할을 담당한다.
 *
 * 지금은 DB 대신 HashMap을 사용해서 메모리에 저장한다.
 * 따라서 서버를 종료하면 저장된 데이터는 모두 사라진다.
 */
@Repository
public class ItemRepository {

    // 실제 데이터를 저장하는 공간
    // Key : 상품 id
    // Value : 상품 객체
    private final Map<Long, Item> store = new HashMap<>();

    // 상품 번호를 자동으로 생성하기 위한 변수
    private long sequence = 0L;

    /**
     * 상품 저장
     *
     * 저장하기 전에 id를 자동 생성한 후
     * Map에 저장한다.
     */
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    /**
     * 전체 상품 조회
     *
     * Map의 모든 값을 List로 변환해서 반환한다.
     */
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    /**
     * id로 상품 하나 조회
     */
    public Item findById(Long id) {
        return store.get(id);
    }

    /**
     * 상품 수정
     *
     * 기존 상품을 찾아서
     * 상품명, 가격, 수량을 변경한다.
     */
    public void update(Long id, Item updateParam) {
        Item findItem = store.get(id);

        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    /**
     * 상품 삭제
     */
    public void delete(Long id) {
        store.remove(id);
    }

    /**
     * 서버 시작 시 자동 실행된다.
     *
     * Postman 실습용 샘플 데이터를 미리 저장해둔다.
     * 실행 직후 GET 요청을 보내면 데이터를 바로 확인할 수 있다.
     */
    @PostConstruct
    public void init() {
        save(new Item("키보드", 89000, 30));
        save(new Item("마우스", 39000, 50));
        save(new Item("모니터", 250000, 12));
    }
}