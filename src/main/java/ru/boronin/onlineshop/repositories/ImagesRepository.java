package ru.boronin.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.boronin.onlineshop.entities.Image;

public interface ImagesRepository extends JpaRepository <Image,Long> {
}
