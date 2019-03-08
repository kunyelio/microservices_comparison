package org.olpexamples.inventories.service;

import org.olpexamples.inventories.dao.entities.InventoryEntity;
import org.olpexamples.inventories.model.Inventory;
import org.olpexamples.inventories.dao.InventoryRepository;
import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;

public class InventoryService {
    @Inject
    protected InventoryRepository inventoryRepository;

    public Collection<Inventory> getAllInventories(){
        return inventoryRepository.findAll().stream().map(this::transformToInventory).collect(Collectors.toList());
    }

    public void setInventory(Inventory inventory){
        InventoryEntity existingEntity = inventoryRepository.getExisting(inventory.getBrand());
        if(existingEntity == null){
            inventoryRepository.setInventory(transformToInventoryEntity(inventory));
        }else{
            existingEntity.setInventory(inventory.getInventory());
            inventoryRepository.setInventory(existingEntity);
        }
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
