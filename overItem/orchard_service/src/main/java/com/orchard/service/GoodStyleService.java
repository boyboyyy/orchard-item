package com.orchard.service;

import com.orchard.dto.GoodStyleDTO;
import com.orchard.dto.GoodStylePageQueryDTO;
import com.orchard.entity.Goodstype;
import com.orchard.result.PageResult;

import java.util.List;

public interface GoodStyleService {
    /**
     * 返回所有货物的数据
     *
     * @return
     */
    List<Goodstype> pageAll();
    /**
     * 货物分类分页查询
     *
     * @param goodStylePageQueryDTO
     * @return
     */
    PageResult goodStylePageQuery(GoodStylePageQueryDTO goodStylePageQueryDTO);

    /**
     * 根据货物分类id查询货物分裂
     *
     * @param id
     * @return
     */
    Goodstype goodStyleById(Long id);

    /**
     * 根据货物数据更新货物
     * @param goodStyleDTO
     */
    void goodStyleUpdate(GoodStyleDTO goodStyleDTO);

    /**
     * 货物分类新增货物
     * @param goodStyleDTO
     */

    void addgoodStyle(GoodStyleDTO goodStyleDTO);

    /**
     * 货物分类的删除
     * @param id
     */
    void goodStyleDelet(Long id);
}
