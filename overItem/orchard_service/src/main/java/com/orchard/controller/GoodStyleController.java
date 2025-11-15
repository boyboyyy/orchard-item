package com.orchard.controller;

import com.orchard.dto.GoodStyleDTO;
import com.orchard.dto.GoodStylePageQueryDTO;
import com.orchard.dto.StorageDTO;
import com.orchard.entity.Goods;
import com.orchard.entity.Storage;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.GoodStyleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/goodStyle")
@Api(tags="货物分类相关接口")
@Slf4j
public class GoodStyleController {
    @Autowired
    private GoodStyleService goodStyleService;
    /**
     * 货物分类查询
     * @param goodStylePageQueryDTO
     * @return
     */
    @PostMapping("/listPage")
    @ApiOperation("货物分类查询")
    public Result<PageResult> page(GoodStylePageQueryDTO goodStylePageQueryDTO){
        log.info("仓库参数",goodStylePageQueryDTO);
        //实现分页操作
        PageResult pageResult = goodStyleService.goodStylePageQuery(goodStylePageQueryDTO);
        //传递前端数据
        return Result.success(pageResult);
    }
    @ApiOperation("根据货物分类id查询货物分类数据")
    @GetMapping("/{id}")
    public Result<Goods> goodStyleById(@PathVariable Long id){
        log.info("货物种类id",id);
        Goods goods  = goodStyleService.goodStyleById(id);
        return Result.success(goods);
    }
    @ApiOperation("修改货物分类信息")
    @PutMapping("/mod")
    public Result goodStyleUpdate(@RequestBody GoodStyleDTO goodStyleDTO){
        log.info("仓库分类信息",goodStyleDTO);
        goodStyleService.goodStyleUpdate(goodStyleDTO);
        return Result.success();
    }

    @ApiOperation("货物分类新增功能")
    @PostMapping("/addStorage")
    public  Result addgoodStyle(@RequestBody GoodStyleDTO goodStyleDTO){
        log.info("goodStyleDTO",goodStyleDTO);
        goodStyleService.addgoodStyle(goodStyleDTO);
        return  Result.success();
    }
    @ApiOperation("货物分类删除功能")
    @GetMapping("/deleteStorageById/{id}")
    public Result goodStyleDelet(@PathVariable Long id){
        log.info("id",id);
        goodStyleService.goodStyleDelet(id);
        return Result.success();
    }
}
