package com.website_of_holding.app_of_holding.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.website_of_holding.app_of_holding.exception.ItemException;
import com.website_of_holding.app_of_holding.model.Item;
import com.website_of_holding.app_of_holding.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ItemService.class})
@ExtendWith(SpringExtension.class)
class ItemServiceTest {
    @MockBean
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    /**
     * Method under test: {@link ItemService#getItems()}
     */
    @Test
    void testGetItems() {
        ArrayList<Item> itemList = new ArrayList<>();
        when(itemRepository.findAll()).thenReturn(itemList);
        List<Item> actualItems = itemService.getItems();
        assertSame(itemList, actualItems);
        assertTrue(actualItems.isEmpty());
        verify(itemRepository).findAll();
    }

    /**
     * Method under test: {@link ItemService#addItem(Item)}
     */
    @Test
    void testAddItem() throws ItemException {
        Item item = new Item();
        item.setId(123L);
        item.setName("Name");
        item.setWeight(10.0d);

        Item item1 = new Item();
        item1.setId(123L);
        item1.setName("Name");
        item1.setWeight(10.0d);
        Optional<Item> ofResult = Optional.of(item1);
        when(itemRepository.save((Item) any())).thenReturn(item);
        when(itemRepository.findItemById((Long) any())).thenReturn(ofResult);

        Item item2 = new Item();
        item2.setId(123L);
        item2.setName("Name");
        item2.setWeight(10.0d);
        assertThrows(ItemException.class, () -> itemService.addItem(item2));
        verify(itemRepository).findItemById((Long) any());
    }

    /**
     * Method under test: {@link ItemService#addItem(Item)}
     */
    @Test
    void testAddItem2() throws ItemException {
        Item item = new Item();
        item.setId(123L);
        item.setName("Name");
        item.setWeight(10.0d);
        when(itemRepository.save((Item) any())).thenReturn(item);
        when(itemRepository.findItemById((Long) any())).thenReturn(Optional.empty());

        Item item1 = new Item();
        item1.setId(123L);
        item1.setName("Name");
        item1.setWeight(10.0d);
        itemService.addItem(item1);
        verify(itemRepository).save((Item) any());
        verify(itemRepository).findItemById((Long) any());
        assertEquals(123L, item1.getId().longValue());
        assertEquals(10.0d, item1.getWeight().doubleValue());
        assertEquals("Name", item1.getName());
    }

    /**
     * Method under test: {@link ItemService#deleteItem(Long)}
     */
    @Test
    void testDeleteItem() throws ItemException {
        doNothing().when(itemRepository).deleteById((Long) any());
        when(itemRepository.existsById((Long) any())).thenReturn(true);
        itemService.deleteItem(123L);
        verify(itemRepository).existsById((Long) any());
        verify(itemRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link ItemService#deleteItem(Long)}
     */
    @Test
    void testDeleteItem2() throws ItemException {
        doNothing().when(itemRepository).deleteById((Long) any());
        when(itemRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(ItemException.class, () -> itemService.deleteItem(123L));
        verify(itemRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link ItemService#updateItem(Long, String, Double)}
     */
    @Test
    void testUpdateItem() throws ItemException {
        Item item = new Item();
        item.setId(123L);
        item.setName("Name");
        item.setWeight(10.0d);
        Optional<Item> ofResult = Optional.of(item);
        when(itemRepository.findItemById((Long) any())).thenReturn(ofResult);
        itemService.updateItem(123L, "Name", 10.0d);
        verify(itemRepository).findItemById((Long) any());
    }

    /**
     * Method under test: {@link ItemService#updateItem(Long, String, Double)}
     */
    @Test
    void testUpdateItem2() throws ItemException {
        when(itemRepository.findItemById((Long) any())).thenReturn(Optional.empty());
        assertThrows(ItemException.class, () -> itemService.updateItem(123L, "Name", 10.0d));
        verify(itemRepository).findItemById((Long) any());
    }
}

