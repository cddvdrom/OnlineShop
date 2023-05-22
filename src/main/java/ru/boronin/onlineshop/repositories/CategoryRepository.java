package ru.boronin.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.boronin.onlineshop.entities.Category;
@Repository

public interface CategoryRepository extends JpaRepository <Category,Long> {
}
