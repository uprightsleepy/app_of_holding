package com.website_of_holding.app_of_holding.repository;

import com.website_of_holding.app_of_holding.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    Optional<Campaign> findCampaignByTitle(String title);
    Optional<Campaign> findCampaignById(Long id);
}
