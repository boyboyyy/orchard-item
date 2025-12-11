package com.orchard.service;

import com.orchard.dto.OrchardDTO;
import com.orchard.dto.OrchardPageQueryDTO;
import com.orchard.dto.RecordDTO;
import com.orchard.entity.OrchardArea;
import com.orchard.result.PageResult;

import java.util.List;

public interface OrchardAreaService {
    /**
     * 地方的分页查询
     * @param orchardPageQueryDTO
     * @return
     */
    PageResult orchardPageQuery(OrchardPageQueryDTO orchardPageQueryDTO);

    /**
     * 地域的新增
     *
     * @param orchardDTO
     */
    void addChardArea(OrchardDTO orchardDTO);

    /**
     * 地域修改
     * @param orchardDTO
     */
    void chardAreaUpdate(OrchardDTO orchardDTO);

    /**
     * 地区的返回地区名
     * @return
     */
    List<OrchardArea> pageAll();
}
