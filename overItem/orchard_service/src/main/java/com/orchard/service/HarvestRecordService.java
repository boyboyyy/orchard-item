package com.orchard.service;

import com.orchard.dto.HarvestRecordPageQueryDTO;
import com.orchard.result.PageResult;

public interface HarvestRecordService {
    /**
     * 采收分页查询
     * @param harvestRecordPageQueryDTO
     * @return
     */
    PageResult harvestPageQuery(HarvestRecordPageQueryDTO harvestRecordPageQueryDTO);
}
