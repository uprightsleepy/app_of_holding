package com.website_of_holding.app_of_holding.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.model.Inventory;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.service.InventoryService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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
    void testCreateInventory() throws Exception {
        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setId(123L);
        campaign.setStartDate(null);
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

        Inventory inventory = new Inventory();
        inventory.setCharacter(playerCharacter);
        inventory.setCopper(1);
        inventory.setElectrum(1);
        inventory.setGold(1);
        inventory.setId(123L);
        inventory.setItems(new ArrayList<>());
        inventory.setPlatinum(10);
        inventory.setSilver(1);
        String content = (new ObjectMapper()).writeValueAsString(inventory);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(inventoryController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
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

