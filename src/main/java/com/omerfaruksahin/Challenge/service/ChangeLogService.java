package com.omerfaruksahin.Challenge.service;

import com.omerfaruksahin.Challenge.dto.response.changeLogResponse.ChangeLogResponseDto;
import com.omerfaruksahin.Challenge.model.Campaign;
import com.omerfaruksahin.Challenge.model.ChangeLog;
import com.omerfaruksahin.Challenge.repository.ChangeLogRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ChangeLogService {
    private final ModelMapper modelMapper;
    private final ChangeLogRepository changeLogRepository;
    public void saveLog(ChangeLog changeLog){
        changeLogRepository.save(changeLog);
    }
    public List<ChangeLogResponseDto> getList(Campaign campaign) {
        return changeLogRepository.findByCampaign(campaign).stream().map(item -> modelMapper.map(item,ChangeLogResponseDto.class)).toList();
    }
}
