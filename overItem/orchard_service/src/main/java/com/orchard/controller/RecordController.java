package com.orchard.controller;

import com.github.pagehelper.PageHelper;
import com.orchard.dto.RecordDTO;
import com.orchard.dto.RecordPageQueryDTO;
import com.orchard.entity.Record;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
@Api(tags="货物记录相关接口")
@Slf4j
public class RecordController {
    @Autowired
    private RecordService recordService;

    /**
     * 货物记录的分页查询
     * @param pageQueryDTO
     * @return
     */
    @PostMapping("/listPage")
    @ApiOperation("货物记录的分类查询")
    public Result<PageResult> page (RecordPageQueryDTO pageQueryDTO){
        log.info("pageQueryDto",pageQueryDTO);
        PageResult pageResult = recordService.recordStypeQuery(pageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 货物新增记录
     * @param recordDTO
     * @return
     */
    @PostMapping("/save")
    @ApiOperation("货物记录新增")
    public Result recordAdd(@RequestBody RecordDTO recordDTO){
        log.info("recorDTO",recordDTO);
        recordService.recordAdd(recordDTO);
        return Result.success();
    }
}
