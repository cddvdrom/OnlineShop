package ru.boronin.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.boronin.onlineshop.entities.Image;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository <Image,Long> {
Image getImageByid(Long id);

}
