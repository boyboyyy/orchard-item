package com.orchard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.dto.TreeInfoPageQueryDTO;
import com.orchard.entity.TreeInfo;
import com.orchard.mapper.TreeInfoMapper;
import com.orchard.result.PageResult;
import com.orchard.service.TreeInfoService;
import com.orchard.vo.TreeinfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeInfoServiceImpl implements TreeInfoService {
    @Autowired
    private TreeInfoMapper treeInfoMapper;
    /**
     * 树木分页的实现
     * @param treeInfoPageQueryDTO
     * @return
     */
    @Override
    public PageResult orchardPageQuery(TreeInfoPageQueryDTO treeInfoPageQueryDTO) {
        PageHelper.startPage(treeInfoPageQueryDTO.getPageNumber(),treeInfoPageQueryDTO.getPageSize());
        Page<TreeinfoVo> page = treeInfoMapper.treeinfo(treeInfoPageQueryDTO);
        long total = page.getTotal();
        List<TreeinfoVo> result = page.getResult();
        return new PageResult(total,result);
    }
}
