package com.orchard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.dto.HarvestRecordPageQueryDTO;
import com.orchard.entity.HarvestRecord;
import com.orchard.entity.OrchardArea;
import com.orchard.mapper.HarvestRecordMapper;
import com.orchard.result.PageResult;
import com.orchard.service.HarvestRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestRecordServiceImpl implements HarvestRecordService {
    @Autowired
    private HarvestRecordMapper harvestRecordMapper;
    /**
     * 采收分页查询
     * @param harvestRecordPageQueryDTO
     * @return
     */
    @Override
    public PageResult harvestPageQuery(HarvestRecordPageQueryDTO harvestRecordPageQueryDTO) {
        PageHelper.startPage(harvestRecordPageQueryDTO.getPageNumber(),harvestRecordPageQueryDTO.getPageSize());
        Page<HarvestRecord> page = harvestRecordMapper.harvestRecord(harvestRecordPageQueryDTO);
        long total = page.getTotal();
        List<HarvestRecord> orchardAreas = page.getResult();
        return new PageResult(total,orchardAreas);
    }
}
