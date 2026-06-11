package main.java.com.likelion.backend.domain.category.repository;

import com.likelion.backend.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
