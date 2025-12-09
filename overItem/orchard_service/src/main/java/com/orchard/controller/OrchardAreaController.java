package com.orchard.controller;

import com.orchard.dto.*;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.OrchardAreaService;
import com.orchard.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orcharArea")
@Api(tags="地区数据相关接口")
@Slf4j
public class OrchardAreaController {
    @Autowired
    private OrchardAreaService orchardAreaService;
    /**
     * 地域分类查询
     * @param orchardPageQueryDTO
     * @return
     */
    @PostMapping("/listPage")
    @ApiOperation("地域分类查询")
    public Result<PageResult> page(OrchardPageQueryDTO orchardPageQueryDTO){
        log.info("仓库参数",orchardPageQueryDTO);
        //实现分页操作
        PageResult pageResult = orchardAreaService.orchardPageQuery(orchardPageQueryDTO);
        //传递前端数据
        return Result.success(pageResult);
    }

    /**
     * 地域新增
     * @param orchardDTO
     * @return
     */
    @ApiOperation("地区新增功能")
    @PostMapping("/addChard")
    public  Result addChardArea(@RequestBody OrchardDTO orchardDTO){
        log.info("orchardDTO",orchardDTO);
        orchardAreaService.addChardArea(orchardDTO);
        return  Result.success();
    }

    /**
     * 地域信息
     * @param orchardDTO
     * @return
     */
    @ApiOperation("修改地区信息")
    @PutMapping("/mod")
    public Result chardAreaUpdate(@RequestBody OrchardDTO orchardDTO){
        log.info("地域信息",orchardDTO);
        orchardAreaService.chardAreaUpdate(orchardDTO);
        return Result.success();
    }
}
