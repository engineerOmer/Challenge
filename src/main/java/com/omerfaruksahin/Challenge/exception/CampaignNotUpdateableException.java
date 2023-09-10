package com.omerfaruksahin.Challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampaignNotUpdateableException extends RuntimeException{
    public CampaignNotUpdateableException(){
        super("Campaign cannot be update because campaign is MÜKERRER");
    }
}
