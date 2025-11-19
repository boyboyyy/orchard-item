package com.orchard.controller;

import com.orchard.dto.StoagePageQueryDTO;
import com.orchard.dto.StorageDTO;
import com.orchard.entity.Goodstype;
import com.orchard.entity.Storage;
import com.orchard.result.PageResult;
import com.orchard.result.Result;
import com.orchard.service.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/storage")
@Api(tags="仓库相关接口")
public class StorageController {
    @Autowired
    private StorageService storageService;
    @ApiOperation("返回所有仓库数据")
    @GetMapping("/list")
    public Result pageAll(){
        List<Storage> storages =  storageService.pageAll();
        return Result.success(storages);
    }
    /**
     * 员工分页查询
     * @param stoagePageQueryDTO
     * @return
     */
    @PostMapping ("/listPage")
    @ApiOperation("仓库分页查询")
    public Result<PageResult> page(StoagePageQueryDTO stoagePageQueryDTO){
        log.info("仓库参数",stoagePageQueryDTO);
        //实现分页操作
        PageResult pageResult = storageService.storagePageQuery(stoagePageQueryDTO);
        //传递前端数据
        return Result.success(pageResult);
    }
    @ApiOperation("根据仓库id查询仓库数据")
    @GetMapping("/{id}")
    public Result<Storage> userById(@PathVariable Long id){
        log.info("仓库id",id);
        Storage storage  = storageService.storageById(id);
        return Result.success(storage);
    }
    @ApiOperation("修改仓库信息")
    @PutMapping("/mod")
    public Result storageUpdate(@RequestBody StorageDTO storageDTO){
        log.info("员工信息",storageDTO);
        storageService.storageUpdate(storageDTO);
        return Result.success();
    }

    @ApiOperation("仓库新增功能")
    @PostMapping("/addStorage")
    public  Result addStorage(@RequestBody StorageDTO storageDTO){
        log.info("stoagePageQueryDTO",storageDTO);
        storageService.addStorage(storageDTO);
        return  Result.success();
    }
    @ApiOperation("仓库删除功能")
    @GetMapping("/deleteStorageById/{id}")
    public Result storageDelet(@PathVariable Long id){
        log.info("id",id);
        storageService.storageDelet(id);
        return Result.success();
    }
}
