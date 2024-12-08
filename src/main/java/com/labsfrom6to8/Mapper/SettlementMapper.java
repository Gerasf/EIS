package com.labsfrom6to8.Mapper;

import com.labsfrom6to8.Model.Settlement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SettlementMapper {

    @Insert("INSERT INTO settlements (name, population, region, is_active) VALUES (#{name}, #{population}, #{region}, #{isActive})")
    void insertSettlement(Settlement settlement);

    @Update("UPDATE settlements SET name = #{name}, population = #{population}, region = #{region}, is_active = #{isActive} WHERE id = #{id}")
    void updateSettlement(Settlement settlement);

    @Select("SELECT * FROM settlements WHERE is_active = TRUE")
    List<Settlement> selectActiveSettlements();

    @Delete("DELETE FROM settlements WHERE id = #{id}")
    void deleteSettlement(Long id);
}
