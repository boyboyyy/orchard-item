package com.orchard.controller;

import com.orchard.dto.GoodDTO;
import com.orchard.dto.GoodPageQueryDTO;
import com.orchard.entity.Goods;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.GoodService;
import com.orchard.vo.GoodsFixVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Goods")
@Api(tags="货物相关接口")
@Slf4j
public class GoodController {
    @Autowired
    private GoodService goodService;
    /**
     * 货物分类查询
     * @param goodPageQueryDTO
     * @return
     */
    @PostMapping("/listPage")
    @ApiOperation("货物查询")
    public Result<PageResult> page(GoodPageQueryDTO goodPageQueryDTO){
        log.info("仓库参数",goodPageQueryDTO);
        //实现分页操作
        PageResult pageResult = goodService.goodPageQuery(goodPageQueryDTO);
        //传递前端数据
        return Result.success(pageResult);
    }
    @ApiOperation("根据货物id查询货物数据")
    @GetMapping("/{id}")
    public Result<GoodsFixVo> goodById(@PathVariable Long id){
        log.info("货物种类id",id);
        GoodsFixVo goodsFixVo  = goodService.goodById(id);
        return Result.success(goodsFixVo);
    }
//    @ApiOperation("修改货物信息")
//    @PutMapping("/mod")
//    public Result goodUpdate(@RequestBody GoodDTO goodDTO){
//        log.info("仓库信息",goodDTO);
//        goodService.goodUpdate(goodDTO);
//        return Result.success();
//    }
//
//    @ApiOperation("货物新增功能")
//    @PostMapping("/addGood")
//    public  Result addgoodStyle(@RequestBody GoodDTO goodDTO){
//        log.info("goodDTO",goodDTO);
//        goodService.addgood(goodDTO);
//        return  Result.success();
//    }
    @ApiOperation("货物分类删除功能")
    @GetMapping("/deleteGoodsById/{id}")
    public Result goodStyleDelet(@PathVariable Long id){
        log.info("id",id);
        goodService.goodDelet(id);
        return Result.success();
    }
}
