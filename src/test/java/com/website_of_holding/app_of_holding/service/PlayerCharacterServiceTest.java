package com.website_of_holding.app_of_holding.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.website_of_holding.app_of_holding.exception.PlayerCharacterException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.model.Inventory;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.InventoryRepository;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private InventoryRepository inventoryRepository;

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
        when(playerCharacterRepository.save((PlayerCharacter) any())).thenReturn(playerCharacter);
        when(playerCharacterRepository.findPlayerCharacterByName((String) any())).thenReturn(ofResult);

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
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.addNewCharacter(playerCharacter2));
        verify(playerCharacterRepository).findPlayerCharacterByName((String) any());
    }

    /**
     * Method under test: {@link PlayerCharacterService#getInventories()}
     */
    @Test
    void testGetInventories() {
        ArrayList<Inventory> inventoryList = new ArrayList<>();
        when(inventoryRepository.findAll()).thenReturn(inventoryList);
        List<Inventory> actualInventories = playerCharacterService.getInventories();
        assertSame(inventoryList, actualInventories);
        assertTrue(actualInventories.isEmpty());
        verify(inventoryRepository).findAll();
    }

    /**
     * Method under test: {@link PlayerCharacterService#deleteCharacter(Long)}
     */
    @Test
    void testDeleteCharacter() throws PlayerCharacterException {
        doNothing().when(playerCharacterRepository).deleteById((Long) any());
        when(playerCharacterRepository.existsById((Long) any())).thenReturn(true);
        when(inventoryRepository.findAll()).thenReturn(new ArrayList<>());
        playerCharacterService.deleteCharacter(123L);
        verify(playerCharacterRepository).existsById((Long) any());
        verify(playerCharacterRepository).deleteById((Long) any());
        verify(inventoryRepository).findAll();
    }

    /**
     * Method under test: {@link PlayerCharacterService#deleteCharacter(Long)}
     */
    @Test
    void testDeleteCharacter2() throws PlayerCharacterException {
        doNothing().when(playerCharacterRepository).deleteById((Long) any());
        when(playerCharacterRepository.existsById((Long) any())).thenReturn(false);
        when(inventoryRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.deleteCharacter(123L));
        verify(playerCharacterRepository).existsById((Long) any());
        verify(inventoryRepository).findAll();
    }

    /**
     * Method under test: {@link PlayerCharacterService#deleteCharacter(Long)}
     */
    @Test
    void testDeleteCharacter3() throws PlayerCharacterException {
        doNothing().when(playerCharacterRepository).deleteById((Long) any());
        when(playerCharacterRepository.existsById((Long) any())).thenReturn(true);

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

        ArrayList<Inventory> inventoryList = new ArrayList<>();
        inventoryList.add(inventory);
        when(inventoryRepository.findAll()).thenReturn(inventoryList);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.deleteCharacter(123L));
        verify(playerCharacterRepository).existsById((Long) any());
        verify(inventoryRepository).findAll();
    }

    /**
     * Method under test: {@link PlayerCharacterService#deleteCharacter(Long)}
     */
    @Test
    void testDeleteCharacter4() throws PlayerCharacterException {
        doNothing().when(playerCharacterRepository).deleteById((Long) any());
        when(playerCharacterRepository.existsById((Long) any())).thenReturn(true);

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
        PlayerCharacter playerCharacter1 = mock(PlayerCharacter.class);
        when(playerCharacter1.getId()).thenReturn(1L);
        doNothing().when(playerCharacter1).setAlignment((String) any());
        doNothing().when(playerCharacter1).setAlive(anyBoolean());
        doNothing().when(playerCharacter1).setCampaign((Campaign) any());
        doNothing().when(playerCharacter1).setCharacterClass((String) any());
        doNothing().when(playerCharacter1).setCharisma(anyInt());
        doNothing().when(playerCharacter1).setConstitution(anyInt());
        doNothing().when(playerCharacter1).setCreatedDate((LocalDateTime) any());
        doNothing().when(playerCharacter1).setDexterity(anyInt());
        doNothing().when(playerCharacter1).setId((Long) any());
        doNothing().when(playerCharacter1).setIntelligence(anyInt());
        doNothing().when(playerCharacter1).setLevel(anyInt());
        doNothing().when(playerCharacter1).setName((String) any());
        doNothing().when(playerCharacter1).setRace((String) any());
        doNothing().when(playerCharacter1).setStrength(anyInt());
        doNothing().when(playerCharacter1).setWisdom(anyInt());
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
        Inventory inventory = mock(Inventory.class);
        when(inventory.getCharacter()).thenReturn(playerCharacter1);
        doNothing().when(inventory).setCharacter((PlayerCharacter) any());
        doNothing().when(inventory).setCopper(anyInt());
        doNothing().when(inventory).setElectrum(anyInt());
        doNothing().when(inventory).setGold(anyInt());
        doNothing().when(inventory).setId((Long) any());
        doNothing().when(inventory).setPlatinum(anyInt());
        doNothing().when(inventory).setSilver(anyInt());
        inventory.setCharacter(playerCharacter);
        inventory.setCopper(1);
        inventory.setElectrum(1);
        inventory.setGold(1);
        inventory.setId(123L);
        inventory.setPlatinum(10);
        inventory.setSilver(1);

        ArrayList<Inventory> inventoryList = new ArrayList<>();
        inventoryList.add(inventory);
        when(inventoryRepository.findAll()).thenReturn(inventoryList);
        playerCharacterService.deleteCharacter(123L);
        verify(playerCharacterRepository).existsById((Long) any());
        verify(playerCharacterRepository).deleteById((Long) any());
        verify(inventoryRepository).findAll();
        verify(inventory).getCharacter();
        verify(inventory).setCharacter((PlayerCharacter) any());
        verify(inventory).setCopper(anyInt());
        verify(inventory).setElectrum(anyInt());
        verify(inventory).setGold(anyInt());
        verify(inventory).setId((Long) any());
        verify(inventory).setPlatinum(anyInt());
        verify(inventory).setSilver(anyInt());
        verify(playerCharacter1).getId();
        verify(playerCharacter1).setAlignment((String) any());
        verify(playerCharacter1).setAlive(anyBoolean());
        verify(playerCharacter1).setCampaign((Campaign) any());
        verify(playerCharacter1).setCharacterClass((String) any());
        verify(playerCharacter1).setCharisma(anyInt());
        verify(playerCharacter1).setConstitution(anyInt());
        verify(playerCharacter1).setCreatedDate((LocalDateTime) any());
        verify(playerCharacter1).setDexterity(anyInt());
        verify(playerCharacter1).setId((Long) any());
        verify(playerCharacter1).setIntelligence(anyInt());
        verify(playerCharacter1).setLevel(anyInt());
        verify(playerCharacter1).setName((String) any());
        verify(playerCharacter1).setRace((String) any());
        verify(playerCharacter1).setStrength(anyInt());
        verify(playerCharacter1).setWisdom(anyInt());
    }

    /**
     * Method under test: {@link PlayerCharacterService#updateCharacter(Long, String, int, String, String, String, int, int, int, int, int, int, boolean)}
     */
    @Test
    void testUpdateCharacter() throws PlayerCharacterException {
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
    void testUpdateCharacter2() throws PlayerCharacterException {

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
        Optional<PlayerCharacter> ofResult = Optional.of(playerCharacter);
        when(playerCharacterRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(PlayerCharacterException.class, () -> playerCharacterService.updateCharacter(123L, "Name", 1, "Race",
                "Artificer", "Alignment", 1, 1, 1, 1, 1, 1, true));
        verify(playerCharacterRepository).findById((Long) any());
    }
}

