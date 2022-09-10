package com.website_of_holding.app_of_holding.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class InventoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Inventory#Inventory()}
     *   <li>{@link Inventory#setCharacter(PlayerCharacter)}
     *   <li>{@link Inventory#setCopper(int)}
     *   <li>{@link Inventory#setElectrum(int)}
     *   <li>{@link Inventory#setGold(int)}
     *   <li>{@link Inventory#setId(Long)}
     *   <li>{@link Inventory#setItems(List)}
     *   <li>{@link Inventory#setPlatinum(int)}
     *   <li>{@link Inventory#setSilver(int)}
     *   <li>{@link Inventory#getCharacter()}
     *   <li>{@link Inventory#getCopper()}
     *   <li>{@link Inventory#getElectrum()}
     *   <li>{@link Inventory#getGold()}
     *   <li>{@link Inventory#getId()}
     *   <li>{@link Inventory#getItems()}
     *   <li>{@link Inventory#getPlatinum()}
     *   <li>{@link Inventory#getSilver()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Inventory actualInventory = new Inventory();
        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.setAlignment("Alignment");
        playerCharacter.setAlive(true);
        playerCharacter.setCampaign(campaign);
        playerCharacter.setCharacterClass("Character Class");
        playerCharacter.setCharisma(1);
        playerCharacter.setConstitution(1);
        playerCharacter.setDexterity(1);
        playerCharacter.setId(123L);
        playerCharacter.setIntelligence(1);
        playerCharacter.setLevel(1);
        playerCharacter.setName("Name");
        playerCharacter.setRace("Race");
        playerCharacter.setStrength(1);
        playerCharacter.setWisdom(1);
        actualInventory.setCharacter(playerCharacter);
        actualInventory.setCopper(1);
        actualInventory.setElectrum(1);
        actualInventory.setGold(1);
        actualInventory.setId(123L);
        ArrayList<Item> itemList = new ArrayList<>();
        actualInventory.setItems(itemList);
        actualInventory.setPlatinum(10);
        actualInventory.setSilver(1);
        assertSame(playerCharacter, actualInventory.getCharacter());
        assertEquals(1, actualInventory.getCopper());
        assertEquals(1, actualInventory.getElectrum());
        assertEquals(1, actualInventory.getGold());
        assertEquals(123L, actualInventory.getId().longValue());
        assertSame(itemList, actualInventory.getItems());
        assertEquals(10, actualInventory.getPlatinum());
        assertEquals(1, actualInventory.getSilver());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Inventory#Inventory(Long, int, int, int, int, int, List, PlayerCharacter)}
     *   <li>{@link Inventory#setCharacter(PlayerCharacter)}
     *   <li>{@link Inventory#setCopper(int)}
     *   <li>{@link Inventory#setElectrum(int)}
     *   <li>{@link Inventory#setGold(int)}
     *   <li>{@link Inventory#setId(Long)}
     *   <li>{@link Inventory#setItems(List)}
     *   <li>{@link Inventory#setPlatinum(int)}
     *   <li>{@link Inventory#setSilver(int)}
     *   <li>{@link Inventory#getCharacter()}
     *   <li>{@link Inventory#getCopper()}
     *   <li>{@link Inventory#getElectrum()}
     *   <li>{@link Inventory#getGold()}
     *   <li>{@link Inventory#getId()}
     *   <li>{@link Inventory#getItems()}
     *   <li>{@link Inventory#getPlatinum()}
     *   <li>{@link Inventory#getSilver()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<Item> itemList = new ArrayList<>();

        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");

        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.setAlignment("Alignment");
        playerCharacter.setAlive(true);
        playerCharacter.setCampaign(campaign);
        playerCharacter.setCharacterClass("Character Class");
        playerCharacter.setCharisma(1);
        playerCharacter.setConstitution(1);
        playerCharacter.setDexterity(1);
        playerCharacter.setId(123L);
        playerCharacter.setIntelligence(1);
        playerCharacter.setLevel(1);
        playerCharacter.setName("Name");
        playerCharacter.setRace("Race");
        playerCharacter.setStrength(1);
        playerCharacter.setWisdom(1);
        Inventory actualInventory = new Inventory(123L, 1, 1, 1, 1, 10, itemList, playerCharacter);
        Campaign campaign1 = new Campaign();
        campaign1.setCompleted(true);
        campaign1.setId(123L);
        campaign1.setStartDate(LocalDate.ofEpochDay(1L));
        campaign1.setTitle("Dr");
        PlayerCharacter playerCharacter1 = new PlayerCharacter();
        playerCharacter1.setAlignment("Alignment");
        playerCharacter1.setAlive(true);
        playerCharacter1.setCampaign(campaign1);
        playerCharacter1.setCharacterClass("Character Class");
        playerCharacter1.setCharisma(1);
        playerCharacter1.setConstitution(1);
        playerCharacter1.setDexterity(1);
        playerCharacter1.setId(123L);
        playerCharacter1.setIntelligence(1);
        playerCharacter1.setLevel(1);
        playerCharacter1.setName("Name");
        playerCharacter1.setRace("Race");
        playerCharacter1.setStrength(1);
        playerCharacter1.setWisdom(1);
        actualInventory.setCharacter(playerCharacter1);
        actualInventory.setCopper(1);
        actualInventory.setElectrum(1);
        actualInventory.setGold(1);
        actualInventory.setId(123L);
        ArrayList<Item> itemList1 = new ArrayList<>();
        actualInventory.setItems(itemList1);
        actualInventory.setPlatinum(10);
        actualInventory.setSilver(1);
        assertSame(playerCharacter1, actualInventory.getCharacter());
        assertEquals(1, actualInventory.getCopper());
        assertEquals(1, actualInventory.getElectrum());
        assertEquals(1, actualInventory.getGold());
        assertEquals(123L, actualInventory.getId().longValue());
        List<Item> items = actualInventory.getItems();
        assertSame(itemList1, items);
        assertEquals(itemList, items);
        assertEquals(10, actualInventory.getPlatinum());
        assertEquals(1, actualInventory.getSilver());
    }
}

