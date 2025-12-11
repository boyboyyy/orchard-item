package com.orchard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.context.BaseContext;
import com.orchard.dto.OrchardDTO;
import com.orchard.dto.OrchardPageQueryDTO;
import com.orchard.entity.OrchardArea;
import com.orchard.entity.Storage;
import com.orchard.mapper.OrchardAreaMapper;
import com.orchard.result.PageResult;
import com.orchard.service.OrchardAreaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    /**
     * 地域新增
     *
     * @param orchardDTO
     */
    @Override
    public void addChardArea(OrchardDTO orchardDTO) {
        OrchardArea orchardArea = new OrchardArea();
        BeanUtils.copyProperties(orchardDTO,orchardArea);
        orchardArea.setCreateTime(LocalDateTime.now());
        orchardAreaMapper.addChardArea(orchardDTO);
    }

    /**
     * 地域修改
     * @param orchardDTO
     */
    @Override
    public void chardAreaUpdate(OrchardDTO orchardDTO) {
        OrchardArea orchardArea = new OrchardArea();
        BeanUtils.copyProperties(orchardDTO,orchardArea);
        orchardArea.setUpdateTime(LocalDateTime.now());
        orchardAreaMapper.updateorchardArea(orchardArea);
    }

    /**
     * 返回地区名
     * @return
     */
    @Override
    public List<OrchardArea> pageAll() {

        return orchardAreaMapper.pageAll();
    }
}
