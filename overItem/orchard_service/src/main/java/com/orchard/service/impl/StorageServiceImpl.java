package com.orchard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.context.BaseContext;
import com.orchard.dto.StoagePageQueryDTO;
import com.orchard.dto.StorageDTO;
import com.orchard.entity.Storage;
import com.orchard.mapper.StorageMapper;
import com.orchard.result.PageResult;
import com.orchard.service.StorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService{
@Autowired
private StorageMapper storageMapper;

    @Override
    public List<Storage> pageAll() {
        return storageMapper.pageAll();
    }

    /**
     * 员工分页查询
     * @param stoagePageQueryDTO
     * @return
     */
    @Override
    public PageResult storagePageQuery(StoagePageQueryDTO stoagePageQueryDTO) {
        //使用PageHelper分页管理器
        PageHelper.startPage(stoagePageQueryDTO.getPageNumber(),stoagePageQueryDTO.getPageSize());
        //模糊查询员工
        Page<Storage> page =  storageMapper.storagePageQuery(stoagePageQueryDTO);
        long total = page.getTotal();
        List<Storage> records  = page.getResult();
        //返回前端分页数据
        return new PageResult(total,records);
    }

    /**
     * 仓库新增
     * @param storageDTO
     */
    @Override
    public void addStorage(StorageDTO storageDTO) {
        Storage storage = new Storage();
        BeanUtils.copyProperties(storageDTO,storage);
        storage.setUpdateTime(LocalDateTime.now());
        storage.setUpdateUser(BaseContext.getCurrentId());
        storageMapper.addStorage(storage);
    }

    /**
     * 仓库删除数据
     * @param id
     */
    @Override
    public void storageDelet(Long id) {
        storageMapper.stroageDelet(id);
    }

    /**
     * 根据员工仓库查找仓库数据
     * @param id
     * @return
     */
    @Override
    public Storage storageById(Long id) {
       Storage storage = storageMapper.storageById(id);
        return storage;
    }

    /**
     * 仓库数据的修改
     * @param storageDTO
     */
    @Override
    public void storageUpdate(StorageDTO storageDTO) {
        Storage storage = new Storage();
        BeanUtils.copyProperties(storageDTO,storage);
        storage.setUpdateUser(BaseContext.getCurrentId());
        storage.setUpdateTime(LocalDateTime.now());
        storageMapper.updateStorage(storage);
    }
}
