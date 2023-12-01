package com.jinnov.jinnovglobalapi.controller;

import com.jinnov.jinnovglobalapi.model.dto.KPIDTO;
import com.jinnov.jinnovglobalapi.model.dto.MondayRequestDTO;
import com.jinnov.jinnovglobalapi.model.enums.KPIBoardsEnum;
import com.jinnov.jinnovglobalapi.service.MondayService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/kpi")
@AllArgsConstructor
@Validated
@Tag(name = "KPI", description = "Specific to KPIs, manages the creation of KPIs, the update of their values and the update of their goals.")
public class KPIController {
    private final MondayService mondayService;
    @GetMapping()
    @Schema(
            title = "Get all KPIs from a board",
            description = "Please set maxResult as small as possible and use pagination to avoid consuming available credits. If the query crashes, please wait 60 seconds."
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<MondayRequestDTO<List<KPIDTO>>> getAllKPI(
            @RequestParam(value = "boardId", defaultValue = "GLOBAL_KPI") KPIBoardsEnum boardId,
            @RequestParam(value = "maxItems", defaultValue = "5") @Max(80) Integer maxItems,
            @RequestParam(value = "cursor") @Nullable String cursor,
            Authentication authentication) {

        String token = authentication.getPrincipal().toString();

        return ResponseEntity.ok(mondayService.getAllKPIs(boardId, maxItems, cursor, token));
    }

    @PostMapping()
    @Schema(
            title = "Add a new record to a KPI"
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<KPIDTO> addNewRecord(
            @RequestParam(value = "parentItemId") String parentItemId,
            @RequestParam(value = "recordDate") @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate recordDate,
            @RequestParam(value = "recordValue") String recordValue,
            Authentication authentication) {

        String token = authentication.getPrincipal().toString();

        return ResponseEntity.ok(mondayService.addNewRecord(parentItemId, recordDate, recordValue, token));
    }
}
