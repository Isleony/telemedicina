package com.hospital.repository;

import com.hospital.model.Inventory;
import com.hospital.model.Inventory.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    
    Optional<Inventory> findByCode(String code);
    
    List<Inventory> findByType(ItemType type);
    
    List<Inventory> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT i FROM Inventory i WHERE i.quantity <= i.minimumQuantity")
    List<Inventory> findLowStockItems();
    
    @Query("SELECT i FROM Inventory i WHERE i.expirationDate <= CURRENT_DATE")
    List<Inventory> findExpiredItems();
}
