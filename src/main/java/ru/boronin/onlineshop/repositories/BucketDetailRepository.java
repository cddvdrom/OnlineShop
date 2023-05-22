package ru.boronin.onlineshop.repositories;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boronin.onlineshop.entities.BucketDetail;
@Repository
public interface BucketDetailRepository extends JpaRepository<BucketDetail,Long> {
}
