package com.omerfaruksahin.Challenge.service;

import com.omerfaruksahin.Challenge.dto.request.changeLogRequest.ChangeLogListRequestDto;
import com.omerfaruksahin.Challenge.dto.request.campaignRequest.SaveCampaignRequestDto;
import com.omerfaruksahin.Challenge.dto.request.campaignRequest.SituationUpdateRequestDto;
import com.omerfaruksahin.Challenge.dto.response.campaignResponse.CampaignResponseDto;
import com.omerfaruksahin.Challenge.dto.response.campaignResponse.CampaignStatusInformationDto;
import com.omerfaruksahin.Challenge.dto.response.changeLogResponse.ChangeLogResponseDto;
import com.omerfaruksahin.Challenge.exception.CampaignNotUpdateableException;
import com.omerfaruksahin.Challenge.model.Campaign;
import com.omerfaruksahin.Challenge.model.CampaignCategory;
import com.omerfaruksahin.Challenge.model.ChangeLog;
import com.omerfaruksahin.Challenge.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;
    private final ModelMapper modelMapper;
    private final ChangeLogService changeLogService;
    public CampaignResponseDto saveCampaign(SaveCampaignRequestDto saveCampaignRequestDto){
        Campaign campaign = modelMapper.map(saveCampaignRequestDto,Campaign.class);
        campaign.setActive(campaign.getCampaignCategory().isActive());
        setMukerrer(campaign);
        campaignRepository.save(campaign);
        return modelMapper.map(campaign,CampaignResponseDto.class);
    }
    private void setMukerrer(Campaign campaign){
        String title = campaign.getCampaignTitle();
        String detail = campaign.getCampaignDetail();
        CampaignCategory campaignCategory1 = campaign.getCampaignCategory();
        if (!campaignRepository.findByCampaignTitleIsAndCampaignDetailIsAndCampaignCategoryIs(title, detail, campaignCategory1).isEmpty()) {
            campaign.setMukerrer(true);
        }
    }
    public CampaignStatusInformationDto getStatus(){
        int active= campaignRepository.findByActiveIsTrue().size();
        int deActive = campaignRepository.findByActiveIsFalse().size();
        return CampaignStatusInformationDto.builder().active(active).deactive(deActive).build();
    }
    public CampaignResponseDto changeStatusInformation(SituationUpdateRequestDto situationUpdateRequestDto) {
        int id = situationUpdateRequestDto.getId();
        boolean active = situationUpdateRequestDto.isActive();
        Campaign campaign = campaignRepository.findById(id).orElseThrow();
        if (campaign.isMukerrer()){
            throw  new CampaignNotUpdateableException();
        }
        campaign.setActive(active);
        changeLogService.saveLog(ChangeLog.builder().dateTime(LocalDateTime.now()).situation(active).campaign(campaign).build());
        return modelMapper.map(campaignRepository.save(campaign), CampaignResponseDto.class);
    }
    public List<ChangeLogResponseDto> getCampaignStatusChange(ChangeLogListRequestDto changeLogListRequestDto){
        Campaign campaign = campaignRepository.findById(changeLogListRequestDto.getCampaignId()).orElseThrow();
        return changeLogService.getList(campaign);
    }
}




