package com.omerfaruksahin.Challenge.service;

import com.omerfaruksahin.Challenge.dto.request.campaignRequest.SaveCampaignRequestDto;
import com.omerfaruksahin.Challenge.dto.request.campaignRequest.SituationUpdateRequestDto;
import com.omerfaruksahin.Challenge.dto.request.changeLogRequest.ChangeLogListRequestDto;
import com.omerfaruksahin.Challenge.dto.response.campaignResponse.CampaignResponseDto;
import com.omerfaruksahin.Challenge.dto.response.campaignResponse.CampaignStatusInformationDto;
import com.omerfaruksahin.Challenge.dto.response.changeLogResponse.ChangeLogResponseDto;
import com.omerfaruksahin.Challenge.model.Campaign;
import com.omerfaruksahin.Challenge.model.CampaignCategory;
import com.omerfaruksahin.Challenge.repository.CampaignRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CampaignServiceTest {
    private CampaignService service;
    private CampaignRepository campaignRepository;
    private  ModelMapper modelMapper;
    private  ChangeLogService changeLogService;

    @BeforeEach
    void setUp(){
        campaignRepository= Mockito.mock(CampaignRepository.class);
        modelMapper= Mockito.mock(ModelMapper.class);
        changeLogService= Mockito.mock(ChangeLogService.class);
        service= new CampaignService(campaignRepository,modelMapper,changeLogService);
    }
    @Test
    public void testSaveCampaign_withValidRequest_ShouldReturnCampaignResponseDto(){
        SaveCampaignRequestDto saveCampaignRequestDto = SaveCampaignRequestDto.builder()
                .campaignTitle("123456789")
                .campaignDetail("dfkljghkdfsmnglnmdskpgkldps")
                .campaignCategory(CampaignCategory.HS)
                .build();

        Campaign  campaign = new Campaign(1,"ASDASDASDASDASDAS","ASDASDASDASDASDASDASDAS",
                true,false,CampaignCategory.HS);
        CampaignResponseDto campaignResponseDto = new CampaignResponseDto("ASDASDASDASDASDAS",
                "ASDASDASDASDASDASDASDAS",true);
        Mockito.when(modelMapper.map(saveCampaignRequestDto,Campaign.class)).thenReturn(campaign);
        Mockito.when(campaignRepository.save(campaign)).thenReturn(campaign);
        Mockito.when(modelMapper.map(campaign,CampaignResponseDto.class)).thenReturn(campaignResponseDto);
        CampaignResponseDto test = service.saveCampaign(saveCampaignRequestDto);
        assertEquals(test,campaignResponseDto);
    }
    @Test
    public void testchangeStatusInformation(){
        SituationUpdateRequestDto saveCampaignRequestDto = new SituationUpdateRequestDto(1, true);


        Campaign  campaign = new Campaign(1,"ASDASDASDASDASDAS","ASDASDASDASDASDASDASDAS",
                true,false,CampaignCategory.HS);

        CampaignResponseDto campaignResponseDto = new CampaignResponseDto("ASDASDASDASDASDAS",
                "ASDASDASDASDASDASDASDAS",true);

        int campaignId= 1;

        Mockito.when(campaignRepository.findById(campaignId)).thenReturn(Optional.of(campaign));
        Mockito.when(campaignRepository.save(campaign)).thenReturn(campaign);
        Mockito.when(modelMapper.map(campaign, CampaignResponseDto.class)).thenReturn(campaignResponseDto);
        CampaignResponseDto result = service.changeStatusInformation(saveCampaignRequestDto);

        assertEquals(result,campaignResponseDto);
    }

    @Test
    public void teststatus(){
        CampaignStatusInformationDto CampaignStatusInformationDto = new CampaignStatusInformationDto(2,1);

        Campaign campaign = new Campaign();

        List<Campaign> act = new ArrayList<>(2);
        act.add(campaign);
        act.add(campaign);

        List<Campaign> deac = new ArrayList<>(1);
        deac.add(campaign);

        Mockito.when(campaignRepository.findByActiveIsFalse()).thenReturn(deac);
        Mockito.when(campaignRepository.findByActiveIsTrue()).thenReturn(act);

        CampaignStatusInformationDto test = service.getStatus();
        assertEquals(test,CampaignStatusInformationDto);
    }


    @Test
    public void testgetCampaignStatusChange(){

        ChangeLogListRequestDto changeLogListRequestDto = new ChangeLogListRequestDto(1);
        Campaign campaign = new Campaign(1,"ahsfjlkasfjlkasfjlaslkfas",
                "aljsfjkasfasfjasklfas",true,false,CampaignCategory.HS);
        List<ChangeLogResponseDto> arr = new ArrayList<>();


        Mockito.when(campaignRepository.findById(1)).thenReturn(Optional.of(campaign));
        Mockito.when(changeLogService.getList(campaign)).thenReturn(arr);
        List<ChangeLogResponseDto> result = service.getCampaignStatusChange(changeLogListRequestDto);

        assertEquals(result, arr);

    }



}
