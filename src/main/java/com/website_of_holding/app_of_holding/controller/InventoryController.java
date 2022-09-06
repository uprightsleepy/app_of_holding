package com.website_of_holding.app_of_holding.controller;

import com.website_of_holding.app_of_holding.exception.InventoryException;
import com.website_of_holding.app_of_holding.model.Inventory;
import com.website_of_holding.app_of_holding.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping
    public List<Inventory> getInventories() {
        return inventoryService.getInventories();
    }

    @PostMapping
    public void createInventory(@RequestBody Inventory inventory) throws InventoryException {
        inventoryService.addInventory(inventory);
    }

    @DeleteMapping(path="{inventoryId}")
    public void deleteInventory(@PathVariable("inventoryId") Long inventoryId) throws InventoryException {
        inventoryService.deleteInventory(inventoryId);
    }

    @PutMapping(path = "{inventoryId}")
    public void updateInventory(
            @PathVariable("inventoryId") Long inventoryId,
            @RequestParam(required = false) int copper,
            @RequestParam(required = false) int silver,
            @RequestParam(required = false) int electrum,
            @RequestParam(required = false) int gold,
            @RequestParam(required = false) int platinum
    ) throws InventoryException {
        inventoryService.updateInventory(inventoryId, copper, silver, electrum, gold, platinum);
    }
}
