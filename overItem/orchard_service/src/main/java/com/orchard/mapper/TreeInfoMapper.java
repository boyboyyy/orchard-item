package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.TreeInfoPageQueryDTO;
import com.orchard.entity.TreeInfo;
import com.orchard.vo.TreeinfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TreeInfoMapper {
    /**
     * 树木信息的分页
     * @param treeInfoPageQueryDTO
     * @return
     */
    Page<TreeinfoVo> treeinfo(TreeInfoPageQueryDTO treeInfoPageQueryDTO);
}
