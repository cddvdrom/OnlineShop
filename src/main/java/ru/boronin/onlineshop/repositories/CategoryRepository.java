package ru.boronin.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.boronin.onlineshop.entities.Category;

public interface CategoryRepository extends JpaRepository <Category,Long> {
}
