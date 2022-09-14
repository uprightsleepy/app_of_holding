package com.website_of_holding.app_of_holding.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.website_of_holding.app_of_holding.exception.CampaignException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.CampaignRepository;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CampaignService.class})
@ExtendWith(SpringExtension.class)
class CampaignServiceTest {
    @MockBean
    private CampaignRepository campaignRepository;

    @Autowired
    private CampaignService campaignService;

    @MockBean
    private PlayerCharacterRepository playerCharacterRepository;

    /**
     * Method under test: {@link CampaignService#getCampaigns()}
     */
    @Test
    void testGetCampaigns() {
        ArrayList<Campaign> campaignList = new ArrayList<>();
        when(campaignRepository.findAll()).thenReturn(campaignList);
        List<Campaign> actualCampaigns = campaignService.getCampaigns();
        assertSame(campaignList, actualCampaigns);
        assertTrue(actualCampaigns.isEmpty());
        verify(campaignRepository).findAll();
    }

    /**
     * Method under test: {@link CampaignService#addCampaign(Campaign)}
     */
    @Test
    void testAddCampaign() throws CampaignException {
        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");

        Campaign campaign1 = new Campaign();
        campaign1.setCompleted(true);
        campaign1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign1.setId(123L);
        campaign1.setStartDate(LocalDate.ofEpochDay(1L));
        campaign1.setTitle("Dr");
        Optional<Campaign> ofResult = Optional.of(campaign1);
        when(campaignRepository.save((Campaign) any())).thenReturn(campaign);
        when(campaignRepository.findCampaignByTitle((String) any())).thenReturn(ofResult);

        Campaign campaign2 = new Campaign();
        campaign2.setCompleted(true);
        campaign2.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign2.setId(123L);
        campaign2.setStartDate(LocalDate.ofEpochDay(1L));
        campaign2.setTitle("Dr");
        assertThrows(CampaignException.class, () -> campaignService.addCampaign(campaign2));
        verify(campaignRepository).findCampaignByTitle((String) any());
    }

    /**
     * Method under test: {@link CampaignService#addCampaign(Campaign)}
     */
    @Test
    void testAddCampaign2() throws CampaignException {
        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");
        when(campaignRepository.save((Campaign) any())).thenReturn(campaign);
        when(campaignRepository.findCampaignByTitle((String) any())).thenReturn(Optional.empty());

        Campaign campaign1 = new Campaign();
        campaign1.setCompleted(true);
        campaign1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign1.setId(123L);
        campaign1.setStartDate(LocalDate.ofEpochDay(1L));
        campaign1.setTitle("Dr");
        campaignService.addCampaign(campaign1);
        verify(campaignRepository).save((Campaign) any());
        verify(campaignRepository).findCampaignByTitle((String) any());
        assertTrue(campaign1.isCompleted());
        assertEquals("01:01", campaign1.getCreatedDate().toLocalTime().toString());
        assertEquals("Dr", campaign1.getTitle());
        assertEquals("1970-01-02", campaign1.getStartDate().toString());
        assertEquals(123L, campaign1.getId().longValue());
    }

    /**
     * Method under test: {@link CampaignService#getCharacters()}
     */
    @Test
    void testGetCharacters() {
        ArrayList<PlayerCharacter> playerCharacterList = new ArrayList<>();
        when(playerCharacterRepository.findAll()).thenReturn(playerCharacterList);
        List<PlayerCharacter> actualCharacters = campaignService.getCharacters();
        assertSame(playerCharacterList, actualCharacters);
        assertTrue(actualCharacters.isEmpty());
        verify(playerCharacterRepository).findAll();
    }

    /**
     * Method under test: {@link CampaignService#deleteCampaign(Long)}
     */
    @Test
    void testDeleteCampaign() throws CampaignException {
        doNothing().when(campaignRepository).deleteById((Long) any());
        when(campaignRepository.existsById((Long) any())).thenReturn(true);
        when(playerCharacterRepository.findAll()).thenReturn(new ArrayList<>());
        campaignService.deleteCampaign(123L);
        verify(campaignRepository).existsById((Long) any());
        verify(campaignRepository).deleteById((Long) any());
        verify(playerCharacterRepository).findAll();
    }

    /**
     * Method under test: {@link CampaignService#deleteCampaign(Long)}
     */
    @Test
    void testDeleteCampaign2() throws CampaignException {
        doNothing().when(campaignRepository).deleteById((Long) any());
        when(campaignRepository.existsById((Long) any())).thenReturn(false);
        when(playerCharacterRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(CampaignException.class, () -> campaignService.deleteCampaign(123L));
        verify(campaignRepository).existsById((Long) any());
        verify(playerCharacterRepository).findAll();
    }

    /**
     * Method under test: {@link CampaignService#deleteCampaign(Long)}
     */
    @Test
    void testDeleteCampaign3() throws CampaignException {
        doNothing().when(campaignRepository).deleteById((Long) any());
        when(campaignRepository.existsById((Long) any())).thenReturn(true);

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

        ArrayList<PlayerCharacter> playerCharacterList = new ArrayList<>();
        playerCharacterList.add(playerCharacter);
        when(playerCharacterRepository.findAll()).thenReturn(playerCharacterList);
        assertThrows(CampaignException.class, () -> campaignService.deleteCampaign(123L));
        verify(campaignRepository).existsById((Long) any());
        verify(playerCharacterRepository).findAll();
    }

    /**
     * Method under test: {@link CampaignService#deleteCampaign(Long)}
     */
    @Test
    void testDeleteCampaign4() throws CampaignException {
        doNothing().when(campaignRepository).deleteById((Long) any());
        when(campaignRepository.existsById((Long) any())).thenReturn(true);

        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");
        Campaign campaign1 = mock(Campaign.class);
        when(campaign1.getId()).thenReturn(1L);
        doNothing().when(campaign1).setCompleted(anyBoolean());
        doNothing().when(campaign1).setCreatedDate((LocalDateTime) any());
        doNothing().when(campaign1).setId((Long) any());
        doNothing().when(campaign1).setStartDate((LocalDate) any());
        doNothing().when(campaign1).setTitle((String) any());
        campaign1.setCompleted(true);
        campaign1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign1.setId(123L);
        campaign1.setStartDate(LocalDate.ofEpochDay(1L));
        campaign1.setTitle("Dr");
        PlayerCharacter playerCharacter = mock(PlayerCharacter.class);
        when(playerCharacter.getCampaign()).thenReturn(campaign1);
        doNothing().when(playerCharacter).setAlignment((String) any());
        doNothing().when(playerCharacter).setAlive(anyBoolean());
        doNothing().when(playerCharacter).setCampaign((Campaign) any());
        doNothing().when(playerCharacter).setCharacterClass((String) any());
        doNothing().when(playerCharacter).setCharisma(anyInt());
        doNothing().when(playerCharacter).setConstitution(anyInt());
        doNothing().when(playerCharacter).setCreatedDate((LocalDateTime) any());
        doNothing().when(playerCharacter).setDexterity(anyInt());
        doNothing().when(playerCharacter).setId((Long) any());
        doNothing().when(playerCharacter).setIntelligence(anyInt());
        doNothing().when(playerCharacter).setLevel(anyInt());
        doNothing().when(playerCharacter).setName((String) any());
        doNothing().when(playerCharacter).setRace((String) any());
        doNothing().when(playerCharacter).setStrength(anyInt());
        doNothing().when(playerCharacter).setWisdom(anyInt());
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

        ArrayList<PlayerCharacter> playerCharacterList = new ArrayList<>();
        playerCharacterList.add(playerCharacter);
        when(playerCharacterRepository.findAll()).thenReturn(playerCharacterList);
        campaignService.deleteCampaign(123L);
        verify(campaignRepository).existsById((Long) any());
        verify(campaignRepository).deleteById((Long) any());
        verify(playerCharacterRepository).findAll();
        verify(playerCharacter).getCampaign();
        verify(playerCharacter).setAlignment((String) any());
        verify(playerCharacter).setAlive(anyBoolean());
        verify(playerCharacter).setCampaign((Campaign) any());
        verify(playerCharacter).setCharacterClass((String) any());
        verify(playerCharacter).setCharisma(anyInt());
        verify(playerCharacter).setConstitution(anyInt());
        verify(playerCharacter).setCreatedDate((LocalDateTime) any());
        verify(playerCharacter).setDexterity(anyInt());
        verify(playerCharacter).setId((Long) any());
        verify(playerCharacter).setIntelligence(anyInt());
        verify(playerCharacter).setLevel(anyInt());
        verify(playerCharacter).setName((String) any());
        verify(playerCharacter).setRace((String) any());
        verify(playerCharacter).setStrength(anyInt());
        verify(playerCharacter).setWisdom(anyInt());
        verify(campaign1).getId();
        verify(campaign1).setCompleted(anyBoolean());
        verify(campaign1).setCreatedDate((LocalDateTime) any());
        verify(campaign1).setId((Long) any());
        verify(campaign1).setStartDate((LocalDate) any());
        verify(campaign1).setTitle((String) any());
    }

    /**
     * Method under test: {@link CampaignService#updateCampaign(Long, String, LocalDate, boolean)}
     */
    @Test
    void testUpdateCampaign() throws CampaignException {
        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");
        Optional<Campaign> ofResult = Optional.of(campaign);
        when(campaignRepository.findById((Long) any())).thenReturn(ofResult);
        campaignService.updateCampaign(123L, "Dr", LocalDate.ofEpochDay(1L), true);
        verify(campaignRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CampaignService#updateCampaign(Long, String, LocalDate, boolean)}
     */
    @Test
    void testUpdateCampaign2() throws CampaignException {
        when(campaignRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(CampaignException.class,
                () -> campaignService.updateCampaign(123L, "Dr", LocalDate.ofEpochDay(1L), true));
        verify(campaignRepository).findById((Long) any());
    }
}

