package com.orchard.service;

import com.orchard.dto.GoodStyleDTO;
import com.orchard.dto.GoodStylePageQueryDTO;
import com.orchard.entity.Goods;
import com.orchard.result.PageResult;
import org.apache.ibatis.annotations.Insert;

public interface GoodStyleService {
    /**
     * 货物分类分页查询
     *
     * @param goodStylePageQueryDTO
     * @return
     */
    PageResult goodStylePageQuery(GoodStylePageQueryDTO goodStylePageQueryDTO);

    /**
     * 根据货物分类id查询货物分裂
     * @param id
     * @return
     */
    Goods goodStyleById(Long id);

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
