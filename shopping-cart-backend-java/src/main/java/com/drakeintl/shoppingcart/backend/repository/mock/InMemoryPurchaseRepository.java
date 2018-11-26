package com.drakeintl.shoppingcart.backend.repository.mock;

import com.drakeintl.shoppingcart.backend.model.Purchase;
import com.drakeintl.shoppingcart.backend.repository.PurchaseRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// in a real-world application, we should not be
// writing this duplicate code; spring data
// should weave the implementation at runtime
// we only have to declare the interfaces
@Component
public class InMemoryPurchaseRepository implements PurchaseRepository {

    private final AtomicLong serialId = new AtomicLong();
    private final Map<Long, Purchase> storage = new HashMap<>();

    @Override
    public Optional<Purchase> find(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Purchase> find(Iterable<Long> ids) {
        synchronized (storage) {
            return StreamSupport.stream(ids.spliterator(), false)
                    .flatMap( (id) -> Stream.of(storage.get(id)))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Purchase> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(storage.values()));
    }

    @Override
    public List<Purchase> save(Iterable<Purchase> purchases) {
        synchronized (storage) {
            for (Purchase purchase : purchases) {
                if (purchase.getId() == null) {
                    purchase.setId(serialId.incrementAndGet());
                }
                storage.put(purchase.getId(), purchase);
            }
        }
        return Collections.unmodifiableList(Lists.newArrayList(purchases));
    }
}
