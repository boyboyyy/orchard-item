package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.HarvestRecordPageQueryDTO;
import com.orchard.entity.HarvestRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HarvestRecordMapper {
    /**
     * 采集分页查询
     *
     * @param harvestRecordPageQueryDTO
     * @return
     */
    Page<HarvestRecord> harvestRecord(HarvestRecordPageQueryDTO harvestRecordPageQueryDTO);
}
