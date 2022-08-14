package com.website_of_holding.app_of_holding.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.service.CampaignService;
import java.time.LocalDate;
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
    void testCreateCampaign() throws Exception {
        Campaign campaign = new Campaign();
        campaign.setCompleted(true);
        campaign.setId(123L);
        campaign.setStartDate(null);
        campaign.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(campaign);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(campaignController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
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

