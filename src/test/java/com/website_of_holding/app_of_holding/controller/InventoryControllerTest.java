package com.website_of_holding.app_of_holding.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.website_of_holding.app_of_holding.exception.InventoryException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.model.Inventory;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.InventoryRepository;
import com.website_of_holding.app_of_holding.service.InventoryService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {InventoryController.class})
@ExtendWith(SpringExtension.class)
class InventoryControllerTest {
    @Autowired
    private InventoryController inventoryController;

    @MockBean
    private InventoryService inventoryService;

    /**
     * Method under test: {@link InventoryController#createInventory(Inventory)}
     */
    @Test
    void testCreateInventory() throws InventoryException {

        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
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
        playerCharacter.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        playerCharacter.setDexterity(1);
        playerCharacter.setId(123L);
        playerCharacter.setIntelligence(1);
        playerCharacter.setLevel(1);
        playerCharacter.setName("Name");
        playerCharacter.setRace("Race");
        playerCharacter.setStrength(1);
        playerCharacter.setWisdom(1);

        Inventory inventory = new Inventory();
        inventory.setCharacter(playerCharacter);
        inventory.setCopper(1);
        inventory.setElectrum(1);
        inventory.setGold(1);
        inventory.setId(123L);
        inventory.setPlatinum(10);
        inventory.setSilver(1);

        Campaign campaign1 = new Campaign();
        campaign1.setCompleted(true);
        campaign1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
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
        playerCharacter1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        playerCharacter1.setDexterity(1);
        playerCharacter1.setId(123L);
        playerCharacter1.setIntelligence(1);
        playerCharacter1.setLevel(1);
        playerCharacter1.setName("Name");
        playerCharacter1.setRace("Race");
        playerCharacter1.setStrength(1);
        playerCharacter1.setWisdom(1);

        Inventory inventory1 = new Inventory();
        inventory1.setCharacter(playerCharacter1);
        inventory1.setCopper(1);
        inventory1.setElectrum(1);
        inventory1.setGold(1);
        inventory1.setId(123L);
        inventory1.setPlatinum(10);
        inventory1.setSilver(1);
        Optional<Inventory> ofResult = Optional.of(inventory1);
        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
        when(inventoryRepository.save((Inventory) any())).thenReturn(inventory);
        when(inventoryRepository.findAll()).thenReturn(new ArrayList<>());
        when(inventoryRepository.findInventoryById((Long) any())).thenReturn(ofResult);
        InventoryController inventoryController = new InventoryController(new InventoryService(inventoryRepository));

        Campaign campaign2 = new Campaign();
        campaign2.setCompleted(true);
        campaign2.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign2.setId(123L);
        campaign2.setStartDate(LocalDate.ofEpochDay(1L));
        campaign2.setTitle("Dr");

        PlayerCharacter playerCharacter2 = new PlayerCharacter();
        playerCharacter2.setAlignment("Alignment");
        playerCharacter2.setAlive(true);
        playerCharacter2.setCampaign(campaign2);
        playerCharacter2.setCharacterClass("Character Class");
        playerCharacter2.setCharisma(1);
        playerCharacter2.setConstitution(1);
        playerCharacter2.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        playerCharacter2.setDexterity(1);
        playerCharacter2.setId(123L);
        playerCharacter2.setIntelligence(1);
        playerCharacter2.setLevel(1);
        playerCharacter2.setName("Name");
        playerCharacter2.setRace("Race");
        playerCharacter2.setStrength(1);
        playerCharacter2.setWisdom(1);

        Inventory inventory2 = new Inventory();
        inventory2.setCharacter(playerCharacter2);
        inventory2.setCopper(1);
        inventory2.setElectrum(1);
        inventory2.setGold(1);
        inventory2.setId(123L);
        inventory2.setPlatinum(10);
        inventory2.setSilver(1);
        inventoryController.createInventory(inventory2);
    }

    /**
     * Method under test: {@link InventoryController#createInventory(Inventory)}
     */
    @Test
    void testCreateInventory2() throws InventoryException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of InventoryController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
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
        playerCharacter.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        playerCharacter.setDexterity(1);
        playerCharacter.setId(123L);
        playerCharacter.setIntelligence(1);
        playerCharacter.setLevel(1);
        playerCharacter.setName("Name");
        playerCharacter.setRace("Race");
        playerCharacter.setStrength(1);
        playerCharacter.setWisdom(1);

        Inventory inventory = new Inventory();
        inventory.setCharacter(playerCharacter);
        inventory.setCopper(1);
        inventory.setElectrum(1);
        inventory.setGold(1);
        inventory.setId(123L);
        inventory.setPlatinum(10);
        inventory.setSilver(1);
        InventoryRepository inventoryRepository = mock(InventoryRepository.class);
        when(inventoryRepository.save((Inventory) any())).thenReturn(inventory);
        when(inventoryRepository.findAll()).thenReturn(new ArrayList<>());
        when(inventoryRepository.findInventoryById((Long) any())).thenReturn(Optional.empty());
        InventoryController inventoryController = new InventoryController(new InventoryService(inventoryRepository));

        Campaign campaign1 = new Campaign();
        campaign1.setCompleted(true);
        campaign1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
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
        playerCharacter1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        playerCharacter1.setDexterity(1);
        playerCharacter1.setId(123L);
        playerCharacter1.setIntelligence(1);
        playerCharacter1.setLevel(1);
        playerCharacter1.setName("Name");
        playerCharacter1.setRace("Race");
        playerCharacter1.setStrength(1);
        playerCharacter1.setWisdom(1);

        Inventory inventory1 = new Inventory();
        inventory1.setCharacter(playerCharacter1);
        inventory1.setCopper(1);
        inventory1.setElectrum(1);
        inventory1.setGold(1);
        inventory1.setId(123L);
        inventory1.setPlatinum(10);
        inventory1.setSilver(1);
        inventoryController.createInventory(inventory1);
        verify(inventoryRepository).save((Inventory) any());
        verify(inventoryRepository).findAll();
        verify(inventoryRepository).findInventoryById((Long) any());
    }

    /**
     * Method under test: {@link InventoryController#createInventory(Inventory)}
     */
    @Test
    void testCreateInventory3() throws InventoryException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of InventoryController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        InventoryService inventoryService = mock(InventoryService.class);
        doNothing().when(inventoryService).addInventory((Inventory) any());
        InventoryController inventoryController = new InventoryController(inventoryService);

        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
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
        playerCharacter.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        playerCharacter.setDexterity(1);
        playerCharacter.setId(123L);
        playerCharacter.setIntelligence(1);
        playerCharacter.setLevel(1);
        playerCharacter.setName("Name");
        playerCharacter.setRace("Race");
        playerCharacter.setStrength(1);
        playerCharacter.setWisdom(1);

        Inventory inventory = new Inventory();
        inventory.setCharacter(playerCharacter);
        inventory.setCopper(1);
        inventory.setElectrum(1);
        inventory.setGold(1);
        inventory.setId(123L);
        inventory.setPlatinum(10);
        inventory.setSilver(1);
        inventoryController.createInventory(inventory);
        verify(inventoryService).addInventory((Inventory) any());
    }

    /**
     * Method under test: {@link InventoryController#deleteInventory(Long)}
     */
    @Test
    void testDeleteInventory() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{inventoryId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(inventoryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link InventoryController#getInventories()}
     */
    @Test
    void testGetInventories() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(inventoryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link InventoryController#updateInventory(Long, int, int, int, int, int)}
     */
    @Test
    void testUpdateInventory() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/{inventoryId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(inventoryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

