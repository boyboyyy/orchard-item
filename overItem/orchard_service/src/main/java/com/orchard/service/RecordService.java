package com.orchard.service;

import com.orchard.dto.RecordDTO;
import com.orchard.dto.RecordPageQueryDTO;
import com.orchard.result.PageResult;
import com.orchard.vo.RecordExcelVo;

import java.time.LocalDateTime;
import java.util.List;

public interface RecordService {
    /**
     * 货物记录的分页查询
     *
     * @param pageQueryDTO
     * @return
     */

    PageResult recordStypeQuery(RecordPageQueryDTO pageQueryDTO);

    /**
     * 记录新增数据
     * @param recordDTO
     */
    void recordAdd(RecordDTO recordDTO);


}
