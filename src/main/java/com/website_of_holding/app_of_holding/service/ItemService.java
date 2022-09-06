package com.website_of_holding.app_of_holding.service;

import com.website_of_holding.app_of_holding.exception.ItemException;
import com.website_of_holding.app_of_holding.model.Item;
import com.website_of_holding.app_of_holding.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void addItem(Item item) throws ItemException {
        Optional<Item> itemOptional = itemRepository.findItemById(item.getId());

        if(itemOptional.isPresent()) {
            throw new ItemException("Unable to create item {" + item.getId() + "} because it already exists.");
        }

        itemRepository.save(item);
    }

    public void deleteItem(Long itemId) throws ItemException {
        boolean exists = itemRepository.existsById(itemId);
        if(!exists) {
            throw new ItemException("Item with ID {" + itemId +"} does not exist.");
        }
        itemRepository.deleteById(itemId);
    }

    @Transactional
    public void updateItem(Long itemId, String name, Double weight) throws ItemException {
        Item item = itemRepository.findItemById(itemId)
                .orElseThrow(() -> new ItemException("Item with ID {" + itemId + "} does not exist."));
        item.setName(name);
        item.setWeight(weight);
    }
}
