package com.orchard.service;

import com.orchard.dto.GoodDTO;
import com.orchard.dto.GoodPageQueryDTO;
import com.orchard.entity.Goods;
import com.orchard.result.PageResult;
import com.orchard.vo.GoodsFixVo;

public interface GoodService {
    /**
     * 货物分类分页查询
     *
     * @param goodPageQueryDTO
     * @return
     */
    PageResult goodPageQuery(GoodPageQueryDTO goodPageQueryDTO);

    /**
     * 根据货物id查询货物
     *
     * @param id
     * @return
     */
    GoodsFixVo goodById(Long id);




    /**
     * 根据货物数据更新货物
     * @param goodDTO
     */
//    void goodUpdate(GoodDTO goodDTO);




    /**
     * 货物的删除
     * @param id
     */
    void goodDelet(Long id);

    /**
     * 货物新增
     * @param goodDTO
     */
//    void addgood(GoodDTO goodDTO);
}
