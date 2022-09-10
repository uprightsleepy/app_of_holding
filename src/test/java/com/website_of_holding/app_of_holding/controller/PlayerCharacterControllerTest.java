package com.website_of_holding.app_of_holding.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.service.PlayerCharacterService;
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

@ContextConfiguration(classes = {PlayerCharacterController.class})
@ExtendWith(SpringExtension.class)
class PlayerCharacterControllerTest {
    @Autowired
    private PlayerCharacterController playerCharacterController;

    @MockBean
    private PlayerCharacterService playerCharacterService;

    /**
     * Method under test: {@link PlayerCharacterController#createCharacter(PlayerCharacter)}
     */
    @Test
    void testCreateCharacter() throws Exception {
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
        String content = (new ObjectMapper()).writeValueAsString(playerCharacter);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(playerCharacterController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link PlayerCharacterController#deleteCharacter(Long)}
     */
    @Test
    void testDeleteCharacter() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{playerCharacterId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(playerCharacterController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link PlayerCharacterController#getCharacters()}
     */
    @Test
    void testGetCharacters() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(playerCharacterController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link PlayerCharacterController#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/{playerCharacterId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(playerCharacterController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

