package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.TreeInfoPageQueryDTO;
import com.orchard.entity.TreeInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TreeInfoMapper {
    /**
     * 树木信息的分页
     * @param treeInfoPageQueryDTO
     * @return
     */
    Page<TreeInfo> treeinfo(TreeInfoPageQueryDTO treeInfoPageQueryDTO);
}
