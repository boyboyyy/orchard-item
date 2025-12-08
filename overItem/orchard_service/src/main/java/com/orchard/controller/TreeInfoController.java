package com.orchard.controller;

import com.orchard.dto.OrchardPageQueryDTO;
import com.orchard.dto.TreeInfoPageQueryDTO;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.OrchardAreaService;
import com.orchard.service.TreeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treeInfo")
@Api(tags="树木相关接口")
@Slf4j
public class TreeInfoController {
    @Autowired
    private TreeInfoService treeInfoService;
    /**
     * 货物分类查询
     * @param treeInfoPageQueryDTO
     * @return
     */
    @PostMapping("/listPage")
    @ApiOperation("地域分类查询")
    public Result<PageResult> page(TreeInfoPageQueryDTO treeInfoPageQueryDTO){
        log.info("树木参数",treeInfoPageQueryDTO);
        //实现分页操作
        PageResult pageResult = treeInfoService.orchardPageQuery(treeInfoPageQueryDTO);
        //传递前端数据
        return Result.success(pageResult);
    }
}
