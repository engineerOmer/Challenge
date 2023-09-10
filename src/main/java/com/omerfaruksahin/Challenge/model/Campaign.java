package com.omerfaruksahin.Challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int campaignId;

    @Size(min = 10,max = 50)
    private String campaignTitle;
    @Size(min = 20,max = 200)
    private String campaignDetail;
    private boolean active;
    private boolean mukerrer = false;
    private CampaignCategory campaignCategory;


}
