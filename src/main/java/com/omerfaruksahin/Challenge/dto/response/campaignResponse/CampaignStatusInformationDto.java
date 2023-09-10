package com.omerfaruksahin.Challenge.dto.response.campaignResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampaignStatusInformationDto {

    private int active;
    private int deactive;
}
