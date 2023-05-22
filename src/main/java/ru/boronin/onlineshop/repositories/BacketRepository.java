package ru.boronin.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.boronin.onlineshop.entities.Bucket;

public interface BacketRepository  extends JpaRepository<Bucket,Long> {
}
