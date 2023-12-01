package com.jinnov.jinnovglobalapi.service;

import com.jinnov.jinnovglobalapi.mapper.externalToDto.MondayMapper;
import com.jinnov.jinnovglobalapi.model.dto.KPIDTO;
import com.jinnov.jinnovglobalapi.model.dto.MondayRequestDTO;
import com.jinnov.jinnovglobalapi.model.enums.KPIBoardsEnum;
import com.jinnov.jinnovglobalapi.model.external.monday.LocalGraphQLResponseBoard;
import com.jinnov.jinnovglobalapi.model.external.monday.LocalGraphQLResponseCreateSubItem;
import com.jinnov.jinnovglobalapi.repository.impl.MondayRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Integer.parseInt;


@Service
@AllArgsConstructor
public class MondayService {
    MondayRepositoryImpl mondayRepository;
    MondayMapper mondayMapper;


    public MondayRequestDTO<List<KPIDTO>> getAllKPIs(KPIBoardsEnum boardId, Integer maxItems, String cursor, String token) {
        LocalGraphQLResponseBoard response = mondayRepository.getBoardItems(
                boardId.getId(),
                maxItems.toString(),
                cursor!=null? "\""+cursor+"\"" : null,
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

    public KPIDTO addNewRecord(String parentItemId, LocalDate recordDate, String recordValue, String token) {
        String recordDateStr = recordDate!=null? recordDate.toString() : LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String columValues = "\"{\\\"date0\\\":\\\"" + recordDateStr + "\\\", \\\"chiffres\\\": " + recordValue + "}\"";

        LocalGraphQLResponseCreateSubItem response = mondayRepository.addSubItem(
                parentItemId,
                "record",
                columValues,
                token
        );

        return mondayMapper.mapItemToKpiDto(response.getCreate_subitem().getParent_item());
    }
}
