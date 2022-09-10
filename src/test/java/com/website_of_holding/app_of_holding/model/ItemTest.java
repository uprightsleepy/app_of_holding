package com.website_of_holding.app_of_holding.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ItemTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Item#Item()}
     *   <li>{@link Item#setId(Long)}
     *   <li>{@link Item#setName(String)}
     *   <li>{@link Item#setWeight(Double)}
     *   <li>{@link Item#getId()}
     *   <li>{@link Item#getName()}
     *   <li>{@link Item#getWeight()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Item actualItem = new Item();
        actualItem.setId(123L);
        actualItem.setName("Name");
        actualItem.setWeight(10.0d);
        assertEquals(123L, actualItem.getId().longValue());
        assertEquals("Name", actualItem.getName());
        assertEquals(10.0d, actualItem.getWeight().doubleValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Item#Item(Long, String, Double)}
     *   <li>{@link Item#setId(Long)}
     *   <li>{@link Item#setName(String)}
     *   <li>{@link Item#setWeight(Double)}
     *   <li>{@link Item#getId()}
     *   <li>{@link Item#getName()}
     *   <li>{@link Item#getWeight()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Item actualItem = new Item(123L, "Name", 10.0d);
        actualItem.setId(123L);
        actualItem.setName("Name");
        actualItem.setWeight(10.0d);
        assertEquals(123L, actualItem.getId().longValue());
        assertEquals("Name", actualItem.getName());
        assertEquals(10.0d, actualItem.getWeight().doubleValue());
    }
}

