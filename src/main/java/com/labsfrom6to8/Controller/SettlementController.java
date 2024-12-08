package com.labsfrom6to8.Controller;

import com.labsfrom6to8.Model.Settlement;
import com.labsfrom6to8.Service.SettlementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settlements")
@Tag(name = "Settlement API", description = "API для управления населенными пунктами")
public class SettlementController {

    private final SettlementService settlementService;

    public SettlementController(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @PostMapping
    @Operation(summary = "Добавить новый населенный пункт", description = "Добавляет новый населенный пункт в систему")
    public void addSettlement(@RequestBody Settlement settlement) {
        settlementService.addSettlement(settlement);
    }

    @PutMapping
    @Operation(summary = "Обновить населенный пункт", description = "Обновляет информацию о населенном пункте")
    public void updateSettlement(@RequestBody Settlement settlement) {
        settlementService.updateSettlement(settlement);
    }

    @GetMapping
    @Operation(summary = "Получить список активных населенных пунктов", description = "Возвращает список всех активных населенных пунктов")
    public List<Settlement> getActiveSettlements() {
        return settlementService.getActiveSettlements();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить населенный пункт", description = "Удаляет населенный пункт по его идентификатору")
    public void deleteSettlement(@PathVariable Long id) {
        settlementService.deleteSettlementById(id);
    }
}
