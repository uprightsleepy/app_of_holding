package com.website_of_holding.app_of_holding.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.website_of_holding.app_of_holding.exception.CampaignException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.repository.CampaignRepository;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;

import java.time.LocalDate;
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
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");

        Campaign campaign1 = new Campaign();
        campaign1.setCompleted(true);
        campaign1.setId(123L);
        campaign1.setStartDate(LocalDate.ofEpochDay(1L));
        campaign1.setTitle("Dr");
        Optional<Campaign> ofResult = Optional.of(campaign1);
        when(campaignRepository.save((Campaign) any())).thenReturn(campaign);
        when(campaignRepository.findCampaignByTitle((String) any())).thenReturn(ofResult);

        Campaign campaign2 = new Campaign();
        campaign2.setCompleted(true);
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
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");
        when(campaignRepository.save((Campaign) any())).thenReturn(campaign);
        when(campaignRepository.findCampaignByTitle((String) any())).thenReturn(Optional.empty());

        Campaign campaign1 = new Campaign();
        campaign1.setCompleted(true);
        campaign1.setId(123L);
        campaign1.setStartDate(LocalDate.ofEpochDay(1L));
        campaign1.setTitle("Dr");
        campaignService.addCampaign(campaign1);
        verify(campaignRepository).save((Campaign) any());
        verify(campaignRepository).findCampaignByTitle((String) any());
        assertEquals(123L, campaign1.getId().longValue());
        assertTrue(campaign1.isCompleted());
        assertEquals("Dr", campaign1.getTitle());
        assertEquals("1970-01-02", campaign1.getStartDate().toString());
    }

    /**
     * Method under test: {@link CampaignService#deleteCampaign(Long)}
     */
    @Test
    void testDeleteCampaign() throws CampaignException {
        doNothing().when(campaignRepository).deleteById((Long) any());
        when(campaignRepository.existsById((Long) any())).thenReturn(true);
        campaignService.deleteCampaign(123L);
        verify(campaignRepository).existsById((Long) any());
        verify(campaignRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link CampaignService#deleteCampaign(Long)}
     */
    @Test
    void testDeleteCampaign2() throws CampaignException {
        doNothing().when(campaignRepository).deleteById((Long) any());
        when(campaignRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(CampaignException.class, () -> campaignService.deleteCampaign(123L));
        verify(campaignRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link CampaignService#updateCampaign(Long, String, LocalDate, boolean)}
     */
    @Test
    void testUpdateCampaign() throws CampaignException {
        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
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

