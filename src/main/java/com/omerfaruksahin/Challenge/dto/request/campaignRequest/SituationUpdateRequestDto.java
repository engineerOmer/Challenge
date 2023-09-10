package com.omerfaruksahin.Challenge.dto.request.campaignRequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SituationUpdateRequestDto {
    private int id;
    private boolean active;
}
