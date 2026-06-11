package com.likelion.backend.domain.item.repository;

import com.likelion.backend.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
