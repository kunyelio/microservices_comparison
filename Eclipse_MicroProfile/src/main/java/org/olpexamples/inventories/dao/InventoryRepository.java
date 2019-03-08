package org.olpexamples.inventories.dao;

import org.olpexamples.inventories.dao.entities.InventoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

public class InventoryRepository {
    @PersistenceContext
    private EntityManager em;

    public void setInventory(InventoryEntity inventory){
        em.persist(inventory);
    }

    public List<InventoryEntity> findAll(){
        return em.createNamedQuery("InventoryEntity.findAll",InventoryEntity.class).getResultList();
    }

    public InventoryEntity getExisting(String brand){
        try{
            InventoryEntity existing = em.createNamedQuery("InventoryEntity.findById", InventoryEntity.class).
                    setParameter("brand", brand).getSingleResult();
            return existing;
        }catch(NoResultException e){
            return null;
        }
    }
}
