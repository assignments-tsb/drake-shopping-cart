package com.drakeintl.shoppingcart.backend;

import com.drakeintl.shoppingcart.backend.model.Item;
import com.drakeintl.shoppingcart.backend.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class ShoppingCartBackendJavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartBackendJavaApplication.class, args);
	}

	//@Autowired
	private final ItemRepository itemRepository;

	@Override
	public void run(String... args) throws Exception {

	    itemRepository.save(
	            Item.builder()
                        .name("Item 1")
                        .quantity(20)
                        .build(),
                Item.builder()
                        .name("Item 2")
                        .quantity(10)
                        .build()
        );


	    log.info("Preloaded Items: " + itemRepository.findAll());
	}
}
