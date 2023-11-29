package com.jinnov.jinnovglobalapi.controller;

import com.jinnov.jinnovglobalapi.model.dto.KPIDTO;
import com.jinnov.jinnovglobalapi.service.MondayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kpi")
@AllArgsConstructor
@Validated
@Tag(name = "KPI", description = "Specific to KPIs, manages the creation of KPIs, the update of their values and the update of their goals.")
public class KPIController {
    private final MondayService mondayService;
    @GetMapping()
    @Operation(summary = "Get all KPIs")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<KPIDTO>> getAllKPI(
            @RequestParam(value = "boardId", defaultValue = "4329614614") long boardId,
            @RequestParam(value = "maxItems", defaultValue = "35") @Max(100) int maxItems,
            Authentication authentication) {

        String token = authentication.getPrincipal().toString();

        return ResponseEntity.ok(mondayService.getAllKPIs(boardId, maxItems, token));
    }
}
