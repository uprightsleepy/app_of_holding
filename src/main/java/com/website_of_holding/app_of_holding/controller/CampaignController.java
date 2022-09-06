package com.website_of_holding.app_of_holding.controller;

import com.website_of_holding.app_of_holding.exception.CampaignException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/campaigns")

public class CampaignController {

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping
    public List<Campaign> getCampaigns() {
        return campaignService.getCampaigns();
    }

    @PostMapping
    public void createCampaign(@RequestBody Campaign campaign) throws CampaignException {
        campaignService.addCampaign(campaign);
    }

    @DeleteMapping(path="{campaignId}")
    public void deleteCampaign(@PathVariable("campaignId") Long campaignId) throws CampaignException {
        campaignService.deleteCampaign(campaignId);
    }

    @PutMapping(path = "{campaignId}")
    public void updateCampaign(
            @PathVariable("campaignId") Long campaignId,
            @RequestParam(required = false) String title,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) boolean completed
    ) throws CampaignException {
        campaignService.updateCampaign(campaignId, title, startDate, completed);
    }
}
