package com.orchard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.dto.OrchardPageQueryDTO;
import com.orchard.entity.OrchardArea;
import com.orchard.mapper.OrchardAreaMapper;
import com.orchard.result.PageResult;
import com.orchard.service.OrchardAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrchardAreaServiceImpl implements OrchardAreaService {
    @Autowired
    private OrchardAreaMapper orchardAreaMapper;
    /**
     * 地域的分页查询
     * @param orchardPageQueryDTO
     * @return
     */
    @Override
    public PageResult orchardPageQuery(OrchardPageQueryDTO orchardPageQueryDTO) {
        PageHelper.startPage(orchardPageQueryDTO.getPageNumber(),orchardPageQueryDTO.getPageSize());
        Page<OrchardArea> page = orchardAreaMapper.orcharArea(orchardPageQueryDTO);
        long total = page.getTotal();
        List<OrchardArea> orchardAreas = page.getResult();
        return new PageResult(total,orchardAreas);
    }
}
