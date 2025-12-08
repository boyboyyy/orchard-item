package com.orchard.service;

import com.orchard.dto.OrchardPageQueryDTO;
import com.orchard.result.PageResult;

public interface OrchardAreaService {
    /**
     * 地方的分页查询
     * @param orchardPageQueryDTO
     * @return
     */
    PageResult orchardPageQuery(OrchardPageQueryDTO orchardPageQueryDTO);
}
