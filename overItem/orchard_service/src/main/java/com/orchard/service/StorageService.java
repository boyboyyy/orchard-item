package com.orchard.service;

import com.orchard.dto.StoagePageQueryDTO;
import com.orchard.dto.StorageDTO;
import com.orchard.entity.Storage;
import com.orchard.result.PageResult;

import java.util.List;

public interface StorageService {

    /**
     * 返回所有的仓库数据
     * @return
     */
    List<Storage> pageAll();

    /**
     * 员工分页查询
     * @param stoagePageQueryDTO
     * @return
     */
    PageResult storagePageQuery(StoagePageQueryDTO stoagePageQueryDTO);

    /**
     * 仓库新增数据
     * @param storageDTO
     */

    void addStorage(StorageDTO storageDTO);

    /**
     * 仓库删除数据
     * @param id
     */
    void storageDelet(Long id);

    /**
     * 根据仓库id查找仓库数据
     * @param id
     * @return
     */
    Storage storageById(Long id);

    /**
     * 修改员工信息
     * @param storageDTO
     */

    void storageUpdate(StorageDTO storageDTO);



}
