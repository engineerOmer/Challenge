package com.omerfaruksahin.Challenge.dto.request.campaignRequest;


import com.omerfaruksahin.Challenge.model.CampaignCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveCampaignRequestDto {

    private String campaignTitle;
    private String campaignDetail;

    private CampaignCategory campaignCategory;
}
