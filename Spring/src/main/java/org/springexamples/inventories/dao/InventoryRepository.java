package org.springexamples.inventories.dao;

import org.springexamples.inventories.dao.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
}
