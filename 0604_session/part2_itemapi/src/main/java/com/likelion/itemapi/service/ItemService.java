package com.likelion.itemapi.service;

import com.likelion.itemapi.domain.Item;
import com.likelion.itemapi.dto.ItemRequest;
import com.likelion.itemapi.dto.ItemResponse;
import com.likelion.itemapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service (비즈니스 로직 계층)
 *
 * Controller와 Repository 사이에서 동작한다.
 *
 * Controller는 요청을 받고,
 * Service는 실제 업무를 처리하고,
 * Repository는 데이터를 저장한다.
 *
 * 또한 DTO ↔ Entity 변환 책임을 담당한다.
 */
@Service
@RequiredArgsConstructor
public class ItemService {

    // 데이터 저장소 사용
    private final ItemRepository itemRepository;

    /**
     * 상품 등록
     *
     * ItemRequest -> Item(Entity) 변환
     * 저장
     * ItemResponse 변환 후 반환
     */
    public ItemResponse create(ItemRequest request) {
        Item item = request.toEntity();

        Item saved = itemRepository.save(item);

        return ItemResponse.from(saved);
    }

    /**
     * 전체 상품 조회
     *
     * Repository가 반환한 Entity 목록을
     * Response DTO 목록으로 변환한다.
     */
    public List<ItemResponse> findAll() {
        return itemRepository.findAll().stream()
                .map(ItemResponse::from)
                .collect(Collectors.toList());
    }

    /**
     * 상품 단건 조회
     */
    public ItemResponse findOne(Long id) {
        return ItemResponse.from(itemRepository.findById(id));
    }

    /**
     * 상품 수정
     *
     * 수정 요청 DTO를 Entity로 변환 후 저장소에 전달
     * 수정된 결과를 다시 조회하여 반환
     */
    public ItemResponse update(Long id, ItemRequest request) {
        itemRepository.update(id, request.toEntity());

        return ItemResponse.from(itemRepository.findById(id));
    }

    /**
     * 상품 삭제
     */
    public void delete(Long id) {
        itemRepository.delete(id);
    }
}