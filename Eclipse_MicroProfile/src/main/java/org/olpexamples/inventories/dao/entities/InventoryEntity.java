package org.olpexamples.inventories.dao.entities;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "car")
@NamedQueries({
@NamedQuery(name = "InventoryEntity.findAll", query = "SELECT e FROM InventoryEntity e"),
@NamedQuery(name = "InventoryEntity.findById", query = "SELECT e FROM InventoryEntity e WHERE e.brand = :brand")})
public class InventoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, length = 25, name = "brand")
    protected String brand;

    @Column(nullable = false, name = "inventory")
    protected Integer inventory;

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
