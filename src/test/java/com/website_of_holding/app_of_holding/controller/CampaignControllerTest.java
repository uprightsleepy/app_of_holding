package com.website_of_holding.app_of_holding.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.website_of_holding.app_of_holding.exception.CampaignException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.repository.CampaignRepository;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;
import com.website_of_holding.app_of_holding.service.CampaignService;

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

@ContextConfiguration(classes = {CampaignController.class})
@ExtendWith(SpringExtension.class)
class CampaignControllerTest {
    @Autowired
    private CampaignController campaignController;

    @MockBean
    private CampaignService campaignService;

    /**
     * Method under test: {@link CampaignController#createCampaign(Campaign)}
     */
    @Test
    void testCreateCampaign() throws CampaignException {

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
        CampaignRepository campaignRepository = mock(CampaignRepository.class);
        when(campaignRepository.save((Campaign) any())).thenReturn(campaign);
        when(campaignRepository.findCampaignByTitle((String) any())).thenReturn(ofResult);
        CampaignController campaignController = new CampaignController(
                new CampaignService(campaignRepository, mock(PlayerCharacterRepository.class)));

        Campaign campaign2 = new Campaign();
        campaign2.setCompleted(true);
        campaign2.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign2.setId(123L);
        campaign2.setStartDate(LocalDate.ofEpochDay(1L));
        campaign2.setTitle("Dr");
        campaignController.createCampaign(campaign2);
    }

    /**
     * Method under test: {@link CampaignController#createCampaign(Campaign)}
     */
    @Test
    void testCreateCampaign2() throws CampaignException {

        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");
        CampaignRepository campaignRepository = mock(CampaignRepository.class);
        when(campaignRepository.save((Campaign) any())).thenReturn(campaign);
        when(campaignRepository.findCampaignByTitle((String) any())).thenReturn(Optional.empty());
        CampaignController campaignController = new CampaignController(
                new CampaignService(campaignRepository, mock(PlayerCharacterRepository.class)));

        Campaign campaign1 = new Campaign();
        campaign1.setCompleted(true);
        campaign1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign1.setId(123L);
        campaign1.setStartDate(LocalDate.ofEpochDay(1L));
        campaign1.setTitle("Dr");
        campaignController.createCampaign(campaign1);
        verify(campaignRepository).save((Campaign) any());
        verify(campaignRepository).findCampaignByTitle((String) any());
    }

    /**
     * Method under test: {@link CampaignController#createCampaign(Campaign)}
     */
    @Test
    void testCreateCampaign3() throws CampaignException {

        CampaignService campaignService = mock(CampaignService.class);
        doNothing().when(campaignService).addCampaign((Campaign) any());
        CampaignController campaignController = new CampaignController(campaignService);

        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        campaign.setId(123L);
        campaign.setStartDate(LocalDate.ofEpochDay(1L));
        campaign.setTitle("Dr");
        campaignController.createCampaign(campaign);
        verify(campaignService).addCampaign((Campaign) any());
    }

    /**
     * Method under test: {@link CampaignController#deleteCampaign(Long)}
     */
    @Test
    void testDeleteCampaign() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{campaignId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(campaignController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CampaignController#getCampaigns()}
     */
    @Test
    void testGetCampaigns() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(campaignController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link CampaignController#updateCampaign(Long, String, LocalDate, boolean)}
     */
    @Test
    void testUpdateCampaign() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/{campaignId}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(campaignController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

