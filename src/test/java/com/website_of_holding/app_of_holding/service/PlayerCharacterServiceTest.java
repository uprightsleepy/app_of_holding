package com.website_of_holding.app_of_holding.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.website_of_holding.app_of_holding.exception.PlayerCharacterException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PlayerCharacterService.class})
@ExtendWith(SpringExtension.class)
class PlayerCharacterServiceTest {
    @MockBean
    private PlayerCharacterRepository playerCharacterRepository;

    @Autowired
    private PlayerCharacterService playerCharacterService;

    /**
     * Method under test: {@link PlayerCharacterService#getCharacters()}
     */
    @Test
    void testGetCharacters() {
        ArrayList<PlayerCharacter> playerCharacterList = new ArrayList<>();
        when(playerCharacterRepository.findAll()).thenReturn(playerCharacterList);
        List<PlayerCharacter> actualCharacters = playerCharacterService.getCharacters();
        assertSame(playerCharacterList, actualCharacters);
        assertTrue(actualCharacters.isEmpty());
        verify(playerCharacterRepository).findAll();
    }

    /**
     * Method under test: {@link PlayerCharacterService#addNewCharacter(PlayerCharacter)}
     */
    @Test
    void testAddNewCharacter() throws PlayerCharacterException {
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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter1);
        when(playerCharacterRepository.save((PlayerCharacter) any())).thenReturn(playerCharacter);
        when(playerCharacterRepository.findPlayerCharacterByName((String) any())).thenReturn(ofResult);

        Campaign campaign2 = new Campaign();
        campaign2.setCompleted(true);
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
        playerCharacter2.setDexterity(1);
        playerCharacter2.setId(123L);
        playerCharacter2.setIntelligence(1);
        playerCharacter2.setLevel(1);
        playerCharacter2.setName("Name");
        playerCharacter2.setRace("Race");
        playerCharacter2.setStrength(1);
        playerCharacter2.setWisdom(1);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.addNewCharacter(playerCharacter2));
        verify(playerCharacterRepository).findPlayerCharacterByName((String) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#addNewCharacter(PlayerCharacter)}
     */
    @Test
    void testAddNewCharacter2() throws PlayerCharacterException {
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
        when(playerCharacterRepository.save((PlayerCharacter) any())).thenReturn(playerCharacter);
        when(playerCharacterRepository.findPlayerCharacterByName((String) any())).thenReturn(Optional.empty());

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
        playerCharacterService.addNewCharacter(playerCharacter1);
        verify(playerCharacterRepository).save((PlayerCharacter) any());
        verify(playerCharacterRepository).findPlayerCharacterByName((String) any());
        assertEquals("Alignment", playerCharacter1.getAlignment());
        assertTrue(playerCharacter1.isAlive());
        assertEquals(1, playerCharacter1.getWisdom());
        assertEquals(1, playerCharacter1.getStrength());
        assertEquals("Race", playerCharacter1.getRace());
        assertEquals("Name", playerCharacter1.getName());
        assertEquals(1, playerCharacter1.getLevel());
        assertEquals(1, playerCharacter1.getIntelligence());
        assertEquals(123L, playerCharacter1.getId().longValue());
        assertEquals(1, playerCharacter1.getDexterity());
        assertEquals(1, playerCharacter1.getConstitution());
        assertEquals(1, playerCharacter1.getCharisma());
        assertEquals("Character Class", playerCharacter1.getCharacterClass());
        assertSame(campaign1, playerCharacter1.getCampaign());
    }

    /**
     * Method under test: {@link PlayerCharacterService#deleteCharacter(Long)}
     */
    @Test
    void testDeleteCharacter() throws PlayerCharacterException {
        doNothing().when(playerCharacterRepository).deleteById((Long) any());
        when(playerCharacterRepository.existsById((Long) any())).thenReturn(true);
        playerCharacterService.deleteCharacter(123L);
        verify(playerCharacterRepository).existsById((Long) any());
        verify(playerCharacterRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#deleteCharacter(Long)}
     */
    @Test
    void testDeleteCharacter2() throws PlayerCharacterException {
        doNothing().when(playerCharacterRepository).deleteById((Long) any());
        when(playerCharacterRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.deleteCharacter(123L));
        verify(playerCharacterRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter() throws PlayerCharacterException {
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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter);
        when(playerCharacterRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, "Name", 1, "Race",
                "Character Class", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCharacter2() throws PlayerCharacterException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.orElseThrow(java.util.function.Supplier)" because the return value of "com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository.findById(Object)" is null
        //       at com.website_of_holding.app_of_holding.service.PlayerCharacterService.updateCharacter(PlayerCharacterService.java:57)
        //   In order to prevent updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean).
        //   See https://diff.blue/R013 to resolve this issue.

        when(playerCharacterRepository.findById((Long) any())).thenReturn(null);
        playerCharacterService.updateCharacter(123L, "Name", 1, "Race", "Character Class", "Alignment", 1, 1, 1, 1, 1, 1,
                true);
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter3() throws PlayerCharacterException {
        when(playerCharacterRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, "Name", 1, "Race",
                "Character Class", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter4() throws PlayerCharacterException {
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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter);
        when(playerCharacterRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, null, 1, "Race",
                "Character Class", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter5() throws PlayerCharacterException {
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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter);
        when(playerCharacterRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, "", 1, "Race",
                "Character Class", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter6() throws PlayerCharacterException {
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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter);
        when(playerCharacterRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, "Name", 0, "Race",
                "Character Class", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter7() throws PlayerCharacterException {
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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter);
        when(playerCharacterRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, "Name", 1, null,
                "Character Class", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter8() throws PlayerCharacterException {
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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter);
        when(playerCharacterRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, "Name", 1, "",
                "Character Class", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter9() throws PlayerCharacterException {
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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter);
        when(playerCharacterRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, "Name", 1, "Race",
                "Artificer", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }
}

