package com.website_of_holding.app_of_holding.controller;

import com.website_of_holding.app_of_holding.exception.ItemException;
import com.website_of_holding.app_of_holding.model.Item;
import com.website_of_holding.app_of_holding.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {this.itemService = itemService;}

    @GetMapping
    public List<Item> getItems() {return itemService.getItems();}

    @PostMapping
    public void createItem(@RequestBody Item item) throws ItemException {
        itemService.addItem(item);
    }

    @DeleteMapping(path="{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) throws ItemException {
        itemService.deleteItem(itemId);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(
            @PathVariable("itemId") Long itemId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double weight
    ) throws ItemException {
        itemService.updateItem(itemId, name, weight);
    }
}
