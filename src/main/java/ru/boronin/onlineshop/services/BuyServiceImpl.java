package ru.boronin.onlineshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.boronin.onlineshop.entities.BucketDetail;
import ru.boronin.onlineshop.repositories.BacketRepository;
import ru.boronin.onlineshop.repositories.BucketDetailRepository;

@Service
public class BuyServiceImpl implements BuyService{
    private final BacketRepository backetRepository;
    private final BucketDetailRepository bucketDetailRepository;
@Autowired
    public BuyServiceImpl(BacketRepository backetRepository, BucketDetailRepository bucketDetailRepository) {
        this.backetRepository = backetRepository;
        this.bucketDetailRepository = bucketDetailRepository;
    }

    @Override
    public void addBasket(BucketDetail bucketDetail) {

    }
}
