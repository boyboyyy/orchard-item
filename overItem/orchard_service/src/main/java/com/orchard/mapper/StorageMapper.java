package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.StoagePageQueryDTO;
import com.orchard.entity.Storage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StorageMapper {
    /**
     * 通过货物姓名查找仓库id
     *
     * @return
     */
//    Integer goodsByName(String name);
    /**
     * 仓库分页
     * @param stoagePageQueryDTO
     * @return
     */
    Page<Storage> storagePageQuery(StoagePageQueryDTO stoagePageQueryDTO);

    /**
     * 仓库新增
     * @param storage
     */
    @Insert("INSERT INTO storage (id,name,remark,create_time,update_time)" + "values" +
            "(#{id},#{name},#{remark},#{createTime},#{updateTime})"   )
    void addStorage(Storage storage);

    /**
     * 仓库删除
     * @param id
     */
    void stroageDelet(Long id);

    /**
     * 根据仓库id查找仓库数据
     * @param id
     * @return
     */
    @Select("select * from storage where id = #{id}")
    Storage storageById(Long id);

    /**
     * 更新仓库数据
     * @param storage
     */
    void updateStorage(Storage storage);

    /**
     * 返回所有仓库信息
     * @return
     */
    List<Storage> pageAll();
}
