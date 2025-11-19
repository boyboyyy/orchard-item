package com.orchard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.dto.RecordDTO;
import com.orchard.dto.RecordPageQueryDTO;
import com.orchard.entity.Record;
import com.orchard.mapper.RecordMapper;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.RecordService;
import com.orchard.vo.RecordPageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    /**
     * 货物记录分页的查询
     *
     * @param pageQueryDTO
     * @return
     */

    @Override
    public PageResult recordStypeQuery(RecordPageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPageNumber(), pageQueryDTO.getPageSize());
        Page<RecordPageVo> page = recordMapper.page(pageQueryDTO);
        long total = page.getTotal();
        List<RecordPageVo> records = page.getResult();
        return new PageResult(total,records);
    }

    /**
     * 记录数据新增
     * @param recordDTO
     */
    @Override
    public void recordAdd(RecordDTO recordDTO) {
        Record record = new Record();
        BeanUtils.copyProperties(recordDTO,record);
        recordMapper.recordAdd(record);

    }
}
