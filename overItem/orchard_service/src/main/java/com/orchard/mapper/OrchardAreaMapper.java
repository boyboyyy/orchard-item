package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.OrchardDTO;
import com.orchard.dto.OrchardPageQueryDTO;
import com.orchard.entity.OrchardArea;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrchardAreaMapper {
    /**
     * 地域分页查询
     * @param orchardPageQueryDTO
     * @return
     */
    Page<OrchardArea> orcharArea(OrchardPageQueryDTO orchardPageQueryDTO);

    /**
     * 地域新增
     * @param orchardDTO
     */
    void addChardArea(OrchardDTO orchardDTO);

    /**
     * 地域修改
     * @param orchardArea
     */
    void updateorchardArea(OrchardArea orchardArea);
}
