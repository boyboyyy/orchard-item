package com.orchard.controller;

import com.orchard.dto.GoodStylePageQueryDTO;
import com.orchard.dto.OrchardPageQueryDTO;
import com.orchard.dto.RecordPageQueryDTO;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.OrchardAreaService;
import com.orchard.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
