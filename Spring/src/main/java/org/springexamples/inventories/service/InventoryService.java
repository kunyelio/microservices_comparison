package org.springexamples.inventories.service;

import org.springexamples.inventories.dao.InventoryRepository;
import org.springexamples.inventories.dao.entities.InventoryEntity;
import org.springexamples.inventories.model.Inventory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class InventoryService {
    protected InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public Collection<Inventory> getAllInventories(){
        return inventoryRepository.findAll().stream().map(this::transformToInventory).collect(Collectors.toList());
    }

    public void setInventory(Inventory inventory){
        inventoryRepository.save(transformToInventoryEntity(inventory));
    }

    private InventoryEntity transformToInventoryEntity(Inventory inventory){
        InventoryEntity e = new InventoryEntity();
        e.setBrand(inventory.getBrand());
        e.setInventory(inventory.getInventory());
        return e;
    }

    private Inventory transformToInventory(InventoryEntity entity){
        Inventory inventory = new Inventory();
        inventory.setBrand(entity.getBrand());
        inventory.setInventory(entity.getInventory());
        return inventory;
    }
}
