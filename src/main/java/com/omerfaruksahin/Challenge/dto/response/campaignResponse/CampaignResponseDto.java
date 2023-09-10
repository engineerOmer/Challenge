package com.omerfaruksahin.Challenge.dto.response.campaignResponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampaignResponseDto {

    private String campaignTitle;

    private String campaignDetail;

    private boolean active;
}
