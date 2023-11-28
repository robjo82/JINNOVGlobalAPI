package com.jinnov.jinnovglobalapi.service;

import com.jinnov.jinnovglobalapi.mapper.externalToDto.MondayMapper;
import com.jinnov.jinnovglobalapi.model.dto.KPIDTO;
import com.jinnov.jinnovglobalapi.repository.impl.MondayRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class MondayService {
    MondayRepositoryImpl mondayRepository;
    MondayMapper mondayMapper;


    public List<KPIDTO> getAllKPIs(long boardId, int maxItems, String token) {
        return mondayMapper.mapResponseToKpiDtoList(mondayRepository.getBoardItems(boardId, maxItems, token));
    }
}
