package com.website_of_holding.app_of_holding.service;

import com.website_of_holding.app_of_holding.exception.InventoryException;
import com.website_of_holding.app_of_holding.model.Inventory;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getInventories() {
        return inventoryRepository.findAll();
    }

    public void addInventory(Inventory inventory) throws InventoryException {
        Optional<Inventory> inventoryOptional = inventoryRepository.findInventoryById(inventory.getId());

        if(inventoryOptional.isPresent()) {
            throw new InventoryException("Unable to add inventory for character {" + inventory.getCharacter().getName() +"} because inventory already exists.");
        }
        for(Inventory i : getInventories()) {
            if(Objects.equals(i.getCharacter().getId(), inventory.getCharacter().getId())) {
                throw new InventoryException("Unable to add inventory for character {" + inventory.getCharacter().getName() +"} because inventory already exists for that character.");
            }
        }
        inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long inventoryId) throws InventoryException {

        boolean exists = inventoryRepository.existsById(inventoryId);
        if(!exists) {
            throw new InventoryException("Inventory with ID {" + inventoryId + "} does not exist.");
        }
        inventoryRepository.deleteById(inventoryId);
    }

    @Transactional
    public void updateInventory(Long inventoryId, int copper, int silver, int electrum, int gold, int platinum) throws InventoryException {

        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new InventoryException("Inventory with id {" + inventoryId + "} does not exist."));
        inventory.setCopper(copper);
        inventory.setSilver(silver);
        inventory.setElectrum(electrum);
        inventory.setGold(gold);
        inventory.setPlatinum(platinum);
    }
}
