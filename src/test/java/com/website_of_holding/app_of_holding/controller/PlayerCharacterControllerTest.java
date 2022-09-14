package com.website_of_holding.app_of_holding.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.website_of_holding.app_of_holding.exception.PlayerCharacterException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.InventoryRepository;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;
import com.website_of_holding.app_of_holding.service.PlayerCharacterService;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Disabled("TODO: Complete this test")
    void testCreateCharacter() throws PlayerCharacterException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PlayerCharacterController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.website_of_holding.app_of_holding.exception.PlayerCharacterException: Unable to create character {Name}. That character already exists!
        //       at com.website_of_holding.app_of_holding.service.PlayerCharacterService.addNewCharacter(PlayerCharacterService.java:43)
        //       at com.website_of_holding.app_of_holding.controller.PlayerCharacterController.createCharacter(PlayerCharacterController.java:30)
        //   In order to prevent createCharacter(PlayerCharacter)
        //   from throwing PlayerCharacterException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createCharacter(PlayerCharacter).
        //   See https://diff.blue/R013 to resolve this issue.

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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter1);
        PlayerCharacterRepository playerCharacterRepository = mock(PlayerCharacterRepository.class);
        when(playerCharacterRepository.save((PlayerCharacter) any())).thenReturn(playerCharacter);
        when(playerCharacterRepository.findPlayerCharacterByName((String) any())).thenReturn(ofResult);
        PlayerCharacterController playerCharacterController = new PlayerCharacterController(
                new PlayerCharacterService(playerCharacterRepository, mock(InventoryRepository.class)));

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
        playerCharacterController.createCharacter(playerCharacter2);
    }

    /**
     * Method under test: {@link PlayerCharacterController#createCharacter(PlayerCharacter)}
     */
    @Test
    void testCreateCharacter2() throws PlayerCharacterException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PlayerCharacterController.
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
        PlayerCharacterRepository playerCharacterRepository = mock(PlayerCharacterRepository.class);
        when(playerCharacterRepository.save((PlayerCharacter) any())).thenReturn(playerCharacter);
        when(playerCharacterRepository.findPlayerCharacterByName((String) any())).thenReturn(Optional.empty());
        PlayerCharacterController playerCharacterController = new PlayerCharacterController(
                new PlayerCharacterService(playerCharacterRepository, mock(InventoryRepository.class)));

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
        playerCharacterController.createCharacter(playerCharacter1);
        verify(playerCharacterRepository).save((PlayerCharacter) any());
        verify(playerCharacterRepository).findPlayerCharacterByName((String) any());
    }

    /**
     * Method under test: {@link PlayerCharacterController#createCharacter(PlayerCharacter)}
     */
    @Test
    void testCreateCharacter3() throws PlayerCharacterException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of PlayerCharacterController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        PlayerCharacterService playerCharacterService = mock(PlayerCharacterService.class);
        doNothing().when(playerCharacterService).addNewCharacter((PlayerCharacter) any());
        PlayerCharacterController playerCharacterController = new PlayerCharacterController(playerCharacterService);

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
        playerCharacterController.createCharacter(playerCharacter);
        verify(playerCharacterService).addNewCharacter((PlayerCharacter) any());
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

