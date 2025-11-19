package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.GoodPageQueryDTO;
import com.orchard.dto.GoodStylePageQueryDTO;
import com.orchard.entity.Goods;
import com.orchard.entity.Goodstype;
import com.orchard.vo.GoodsFixVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodMapper {
    /**
     * 货物查询
     * @param goodPageQueryDTO
     * @return
     */
    Page<GoodsFixVo> goodsPageQusery(GoodPageQueryDTO goodPageQueryDTO);

    /**
     * 货物分类的修改
     * @param goods
     */
//    void updateGood(Goods goods);

    /**
     * 通过id查询货物分类
     * @param id
     * @return
     */

    GoodsFixVo goodById(Long id);



    /**
     * 根据id删除货物分类
     * @param id
     */
    void goodDelet(Long id);



    /**
     * 货物新增
     * @param goods
     */
//    @Insert("insert into goods (name,storage,goodsType,count,remark,create_time,create_user)" + "values" +
//            "(#{name},#{storage},#{goodsType},#{count},#{remark},#{createTime},#{createUser})")
//    void addgood(Goods goods);




}
