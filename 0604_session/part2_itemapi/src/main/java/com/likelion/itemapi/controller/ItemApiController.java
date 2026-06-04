package com.likelion.itemapi.controller;

import com.likelion.itemapi.dto.ItemRequest;
import com.likelion.itemapi.dto.ItemResponse;
import com.likelion.itemapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller (API 입구)
 *
 * 클라이언트의 HTTP 요청을 가장 먼저 받는 계층이다.
 * 요청 데이터를 받아 Service에 전달하고,
 * Service가 처리한 결과를 응답으로 반환한다.
 *
 * GET    /api/items       -> 전체 조회
 * GET    /api/items/{id}  -> 단건 조회
 * POST   /api/items       -> 상품 등록
 * PUT    /api/items/{id}  -> 상품 수정
 * DELETE /api/items/{id}  -> 상품 삭제
 */
@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemApiController {

    // 비즈니스 로직 처리를 Service에게 위임
    private final ItemService itemService;

    /**
     * 전체 상품 조회
     *
     * GET /api/items
     */
    @GetMapping
    public List<ItemResponse> getItems() {
        return itemService.findAll();
    }

    /**
     * 상품 한 건 조회
     *
     * URL 예시:
     * GET /api/items/1
     *
     * @PathVariable
     * URL 경로에 있는 값을 변수로 받아온다.
     */
    @GetMapping("/{id}")
    public ItemResponse getItem(@PathVariable Long id) {
        return itemService.findOne(id);
    }

    /**
     * 상품 등록
     *
     * POST /api/items
     *
     * @RequestBody
     * 요청 본문의 JSON 데이터를
     * ItemRequest 객체로 변환한다.
     */
    @PostMapping
    public ItemResponse createItem(@RequestBody ItemRequest request) {
        return itemService.create(request);
    }

    /**
     * 상품 수정
     *
     * PUT /api/items/{id}
     *
     * 수정할 상품 번호는 URL에서 받고,
     * 수정할 데이터는 Request Body에서 받는다.
     */
    @PutMapping("/{id}")
    public ItemResponse updateItem(@PathVariable Long id,
                                   @RequestBody ItemRequest request) {
        return itemService.update(id, request);
    }

    /**
     * 상품 삭제
     *
     * DELETE /api/items/{id}
     */
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.delete(id);
    }
}