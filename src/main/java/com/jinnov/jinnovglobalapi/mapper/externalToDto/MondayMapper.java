package com.jinnov.jinnovglobalapi.mapper.externalToDto;

import com.jinnov.jinnovglobalapi.model.dto.KPIReportDTO;
import com.jinnov.jinnovglobalapi.model.external.monday.LocalGraphQLResponse;
import com.jinnov.jinnovglobalapi.model.dto.KPIDTO;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MondayMapper {
    private static final String CHIFFRES = "chiffres";
    private static final String DATE = "date";
    private static final String DATE0 = "date0";
    private static final String PERSONNES = "personnes";
    private static final String DUREE = "dur_e";

    public KPIDTO mapItemToKpiDto(LocalGraphQLResponse.Board.ItemsPage.Item item) {
        KPIDTO kpiDto = new KPIDTO();
        kpiDto.setDescription(item.getName());

        for (LocalGraphQLResponse.Board.ItemsPage.Item.ColumnValue columnValue : item.getColumn_values()) {
            switch (columnValue.getId()) {
                case CHIFFRES:
                    kpiDto.setGoal(columnValue.getText());
                    break;
                case DATE:
                    kpiDto.setDeadline(columnValue.getText());
                    break;
                case PERSONNES:
                    kpiDto.setOwner(columnValue.getText());
                    break;
                case DUREE:
                    kpiDto.setReportingFrequency(columnValue.getText());
                    break;
            }
        }

        if (item.getSubitems() != null && !item.getSubitems().isEmpty()) {
            List<LocalGraphQLResponse.Board.ItemsPage.Item.SubItem> sortedSubItems = item.getSubitems().stream()
                    .sorted(Comparator.comparing(subItem -> LocalDate.parse(getColumnValue(subItem.getColumn_values(), DATE0))))
                    .toList();

            LocalGraphQLResponse.Board.ItemsPage.Item.SubItem lastSubItem = sortedSubItems.get(sortedSubItems.size() - 1);
            kpiDto.setLastValue(getColumnValue(lastSubItem.getColumn_values(), CHIFFRES));
            kpiDto.setLastUpdate(getColumnValue(lastSubItem.getColumn_values(), DATE0));
            kpiDto.setNextUpdate(calculateNextUpdate(kpiDto.getLastUpdate(), kpiDto.getReportingFrequency()));
            kpiDto.setAdvancement(calculateAdvancement(kpiDto.getLastValue(), kpiDto.getGoal()));

            kpiDto.setHistory(sortedSubItems.stream()
                    .map(subItem -> new KPIReportDTO(getColumnValue(subItem.getColumn_values(), DATE0), getColumnValue(subItem.getColumn_values(), CHIFFRES)))
                    .toList());
        }

        return kpiDto;
    }

    private String getColumnValue(List<LocalGraphQLResponse.Board.ItemsPage.Item.ColumnValue> columnValues, String id) {
        return columnValues.stream()
                .filter(cv -> cv.getId().equals(id))
                .findFirst()
                .map(LocalGraphQLResponse.Board.ItemsPage.Item.ColumnValue::getText)
                .orElse(null);
    }

    private String calculateNextUpdate(String lastUpdate, String reportingFrequency) {
        if (lastUpdate == null || reportingFrequency == null) return null;
        LocalDate lastUpdateDate = LocalDate.parse(lastUpdate);
        return lastUpdateDate.plusDays(Long.parseLong(reportingFrequency)).toString();
    }

    private String calculateAdvancement(String lastValue, String goal) {
        if (lastValue == null || goal == null || goal.equals("0")) return null;
        return String.format("%.2f%%", (Double.parseDouble(lastValue) / Double.parseDouble(goal)) * 100);
    }

    public List<KPIDTO> mapResponseToKpiDtoList(LocalGraphQLResponse response) {
        return response.getBoards().stream()
                .flatMap(board -> board.getItems_page().getItems().stream())
                .map(this::mapItemToKpiDto)
                .collect(Collectors.toList());
    }
}
