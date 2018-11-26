package com.drakeintl.shoppingcart.backend.repository.mock;

import com.drakeintl.shoppingcart.backend.model.Item;
import com.drakeintl.shoppingcart.backend.repository.ItemRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class InMemoryItemRepository implements ItemRepository {

    private final AtomicLong serialId = new AtomicLong();
    private final Map<Long, Item> storage = new HashMap<>();

    @Override
    public Optional<Item> find(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Item> find(Iterable<Long> ids) {
        synchronized (storage) {
            return StreamSupport.stream(ids.spliterator(), false)
                    .flatMap( (id) -> Stream.of(storage.get(id)))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Item> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(storage.values()));
    }

    @Override
    public List<Item> save(Iterable<Item> items) {
        synchronized (storage) {
            for (Item item : items) {
                if (item.getId() == null) {
                    item.setId(serialId.incrementAndGet());
                }
                storage.put(item.getId(), item);
            }
        }
        return Collections.unmodifiableList(Lists.newArrayList(items));
    }
}
