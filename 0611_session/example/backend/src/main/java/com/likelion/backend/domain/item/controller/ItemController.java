package main.java.com.likelion.backend.domain.item.controller;

import com.likelion.backend.domain.item.dto.ItemRequest;
import com.likelion.backend.domain.item.dto.ItemResponse;
import com.likelion.backend.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ItemResponse createItem(@RequestBody ItemRequest request) {
        return itemService.createItem(request);
    }

    @GetMapping
    public List<ItemResponse> getItems() {
        return itemService.getItems();
    }
}
