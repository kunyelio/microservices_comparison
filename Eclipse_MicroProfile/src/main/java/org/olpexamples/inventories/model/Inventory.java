package org.olpexamples.inventories.model;

import javax.validation.constraints.NotNull;

public class Inventory {

    @NotNull
    private String brand;

    private Integer inventory;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

}
