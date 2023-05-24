package ru.boronin.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boronin.onlineshop.entities.MyUser;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findByEmail(String email);

    void deleteById(Long id);
}
