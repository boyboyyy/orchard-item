package com.orchard.service;

import com.orchard.dto.TreeInfoPageQueryDTO;
import com.orchard.result.PageResult;

public interface TreeInfoService {
    /**
     * 树木的分页
     * @param treeInfoPageQueryDTO
     * @return
     */
    PageResult orchardPageQuery(TreeInfoPageQueryDTO treeInfoPageQueryDTO);
}
