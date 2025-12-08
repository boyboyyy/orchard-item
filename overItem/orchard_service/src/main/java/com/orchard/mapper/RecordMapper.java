package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.RecordPageQueryDTO;
import com.orchard.entity.Record;
import com.orchard.vo.RecordExcelVo;
import com.orchard.vo.RecordPageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordMapper {
    /**
     * 货物记录的分页
     * @param recordPageQueryDTO
     * @return
     */
    Page<RecordPageVo> page(RecordPageQueryDTO recordPageQueryDTO);

    /**
     * 记录新增数据
     * @param record
     */
    void recordAdd(Record record);

    /**
     * 时间段导出excel文件
     * @param
     * @return
     */
    List<RecordExcelVo> recordByTime();
}
