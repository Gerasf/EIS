package com.labsfrom6to8.Service;


import com.labsfrom6to8.Mapper.SettlementMapper;
import com.labsfrom6to8.Model.Settlement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettlementService {

    private final SettlementMapper settlementMapper;

    public SettlementService(SettlementMapper settlementMapper) {
        this.settlementMapper = settlementMapper;
    }

    public void addSettlement(Settlement settlement) {
        settlementMapper.insertSettlement(settlement);
    }

    public void updateSettlement(Settlement settlement) {
        settlementMapper.updateSettlement(settlement);
    }

    public List<Settlement> getActiveSettlements() {
        return settlementMapper.selectActiveSettlements();
    }

    public void deleteSettlementById(Long id) {
        settlementMapper.deleteSettlement(id);
    }
}
