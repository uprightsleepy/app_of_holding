package com.website_of_holding.app_of_holding.service;

import com.website_of_holding.app_of_holding.exception.CampaignException;
import com.website_of_holding.app_of_holding.exception.PlayerCharacterException;
import com.website_of_holding.app_of_holding.model.Campaign;
import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import com.website_of_holding.app_of_holding.repository.CampaignRepository;
import com.website_of_holding.app_of_holding.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final PlayerCharacterRepository playerCharacterRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository, PlayerCharacterRepository playerCharacterRepository) {
        this.campaignRepository = campaignRepository;
        this.playerCharacterRepository = playerCharacterRepository;
    }

    public List<Campaign> getCampaigns() {

        return campaignRepository.findAll();
    }

    public void addCampaign(Campaign campaign) throws CampaignException {
        Optional<Campaign> campaignOptional = campaignRepository.findCampaignByTitle(campaign.getTitle());

        if(campaignOptional.isPresent()) {
            throw new CampaignException("Unable to create campaign {" + campaign.getTitle() + "} because name already exists.");
        }
        campaignRepository.save(campaign);
    }
    public List<PlayerCharacter> getCharacters() {
        return playerCharacterRepository.findAll();
    }
    public void deleteCampaign(Long campaignId) throws CampaignException {
        List<PlayerCharacter> characters = getCharacters();

        boolean exists = campaignRepository.existsById(campaignId);
        if(!exists) {
            throw new CampaignException("Campaign with ID {" + campaignId + "} does not exist.");
        }
        for(PlayerCharacter c : characters) {
            if(Objects.equals(c.getCampaign().getId(), campaignId)) {
                throw new CampaignException("Unable to delete campaign with ID{"
                        + campaignId + "}. It contains a character!");
            }
        }
        campaignRepository.deleteById(campaignId);
    }

    @Transactional
    public void updateCampaign(Long campaignId, String title,
                               LocalDate startDate, boolean completed) throws CampaignException {

        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new CampaignException("Campaign with id {" + campaignId + "} does not exist."));
        campaign.setTitle(title);
        campaign.setStartDate(startDate);
        campaign.setCompleted(completed);
    }
}