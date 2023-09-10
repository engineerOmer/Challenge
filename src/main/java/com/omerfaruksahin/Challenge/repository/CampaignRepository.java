package com.omerfaruksahin.Challenge.repository;

import com.omerfaruksahin.Challenge.model.Campaign;
import com.omerfaruksahin.Challenge.model.CampaignCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Integer> {
    List<Campaign> findByActiveIsFalse();
    List<Campaign> findByActiveIsTrue();
    List<Campaign> findByCampaignTitleIsAndCampaignDetailIsAndCampaignCategoryIs(String title, String detail, CampaignCategory campaignCategory);
}
