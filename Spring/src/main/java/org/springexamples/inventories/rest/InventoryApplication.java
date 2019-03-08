package org.springexamples.inventories.rest;

import org.springexamples.inventories.dao.InventoryRepository;
import org.springexamples.inventories.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.springexamples.inventories.dao.entities")
@EnableJpaRepositories("org.springexamples.inventories.dao")
public class InventoryApplication {

    @Autowired
    protected InventoryRepository inventoryRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "inventory-application");
        SpringApplication.run(InventoryApplication.class, args);
    }


    @Bean
    public InventoryService service(){
        return new InventoryService(inventoryRepository);
    }
}
