package com.orchard.controller;

import com.orchard.dto.HarvestRecordPageQueryDTO;
import com.orchard.dto.OrchardPageQueryDTO;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.HarvestRecordService;
import com.orchard.service.OrchardAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/harvestRecord")
@Api(tags="采集记录相关接口")
@Slf4j
public class HarvestRecordController {
    @Autowired
    private HarvestRecordService harvestRecordService;
    /**
     * 采收分类查询
     * @param harvestRecordPageQueryDTO
     * @return
     */
    @PostMapping("/listPage")
    @ApiOperation("采收分类查询")
    public Result<PageResult> page(HarvestRecordPageQueryDTO harvestRecordPageQueryDTO){
        log.info("仓库参数",harvestRecordPageQueryDTO);
        //实现分页操作
        PageResult pageResult = harvestRecordService.harvestPageQuery(harvestRecordPageQueryDTO);
        //传递前端数据
        return Result.success(pageResult);
    }
}
