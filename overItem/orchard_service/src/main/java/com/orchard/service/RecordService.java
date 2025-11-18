package com.orchard.service;

import com.orchard.dto.RecordPageQueryDTO;
import com.orchard.entity.Record;
import com.orchard.result.PageResult;

public interface RecordService {
    /**
     * 货物记录的分页查询
     *
     * @param pageQueryDTO
     * @return
     */

    PageResult recordStypeQuery(RecordPageQueryDTO pageQueryDTO);
}
