package com.jinnov.jinnovglobalapi.service;

import com.jinnov.jinnovglobalapi.mapper.externalToDto.MondayMapper;
import com.jinnov.jinnovglobalapi.model.dto.KPIDTO;
import com.jinnov.jinnovglobalapi.model.dto.MondayRequestDTO;
import com.jinnov.jinnovglobalapi.model.enums.KPIBoards;
import com.jinnov.jinnovglobalapi.model.external.monday.LocalGraphQLResponse;
import com.jinnov.jinnovglobalapi.repository.impl.MondayRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;


@Service
@AllArgsConstructor
public class MondayService {
    MondayRepositoryImpl mondayRepository;
    MondayMapper mondayMapper;


    public MondayRequestDTO<List<KPIDTO>> getAllKPIs(KPIBoards boardId, Integer maxItems, String cursor, String token) {
        LocalGraphQLResponse response = mondayRepository.getBoardItems(
                boardId.getId(),
                maxItems.toString(),
                cursor,
                token
        );

        List<KPIDTO> kpiDtoList = mondayMapper.mapResponseToKpiDtoList(response);

        return new MondayRequestDTO<>(
                response.getBoards().get(0).getItems_page().getCursor(),
                parseInt(response.getComplexity().getReset_in_x_seconds()),
                parseInt(response.getComplexity().getAfter())/ parseInt(response.getComplexity().getQuery()),
                kpiDtoList
        );
    }
}
