package com.website_of_holding.app_of_holding.repository;

import com.website_of_holding.app_of_holding.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findInventoryById(Long id);
    Optional<Inventory> findInventoryByCharacterName(String name);
}
