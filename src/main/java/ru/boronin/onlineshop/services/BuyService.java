package ru.boronin.onlineshop.services;

import org.springframework.stereotype.Service;
import ru.boronin.onlineshop.entities.BucketDetail;
import ru.boronin.onlineshop.entities.Product;
@Service
public interface BuyService {
    void addBasket(BucketDetail bucketDetail);
}
