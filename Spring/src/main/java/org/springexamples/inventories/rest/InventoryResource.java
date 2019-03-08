package org.springexamples.inventories.rest;

import org.springexamples.inventories.model.Inventory;
import org.springexamples.inventories.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/cars")
public class InventoryResource {

    @Autowired
    protected InventoryService service;

    @Autowired
    public InventoryResource(InventoryService service){
        this.service = service;
    }

    @RequestMapping(value = "/inventories", produces = { "application/json" }, method= {RequestMethod.GET})
    public Collection<Inventory> getInventories(){
        return service.getAllInventories();
    }

    @RequestMapping(value = "/setInventory", consumes = { "application/json" }, method= {RequestMethod.POST})
    public void setInventory(@RequestBody Inventory inventory){
        service.setInventory(inventory);
    }

}
