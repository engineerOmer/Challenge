package com.omerfaruksahin.Challenge.model;

import lombok.Getter;

@Getter
public enum CampaignCategory {
    TSS("TAMAMLAYICI_SAGLIK_SIGORTASI", false),
    OSS("OZEL_SAGLIK_SIGORTASI", false),
    HS("OZEL_SAGLIK_SIGORTASI", true),
    DIGER("DIGER", false);

    private final String abbreviation;

    private final boolean active;

    CampaignCategory(String abbreviation, boolean active) {
        this.abbreviation = abbreviation;
        this.active = active;
    }


}
