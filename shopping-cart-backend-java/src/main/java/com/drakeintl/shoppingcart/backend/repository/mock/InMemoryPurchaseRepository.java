package com.drakeintl.shoppingcart.backend.repository.mock;

import com.drakeintl.shoppingcart.backend.model.Purchase;
import com.drakeintl.shoppingcart.backend.repository.PurchaseRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InMemoryPurchaseRepository implements PurchaseRepository {

    @Override
    public Optional<Purchase> find(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Purchase> find(Iterable<Long> longs) {
        return null;
    }

    @Override
    public List<Purchase> findAll() {
        return null;
    }

    @Override
    public List<Purchase> save(Iterable<Purchase> entities) {
        return null;
    }
}
