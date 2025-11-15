package com.orchard.mapper;

import com.github.pagehelper.Page;
import com.orchard.dto.GoodStyleDTO;
import com.orchard.dto.GoodStylePageQueryDTO;
import com.orchard.entity.Goods;
import com.orchard.entity.Goodstype;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GoodStyleMapper {

    /**
     * 货物分类查询
     * @param goodStylePageQueryDTO
     * @return
     */
    Page<Goods> goodsPageQusery(GoodStylePageQueryDTO goodStylePageQueryDTO);

    /**
     * 货物分类的修改
     * @param goodstype
     */
    void updateGoodStyle(Goodstype goodstype);

    /**
     * 通过id查询货物分类
     * @param id
     * @return
     */
    @Select("select * from goodstype where id = #{id}")
    Goods goodStyleById(Long id);

    /**
     * 根据id删除货物分类
     * @param id
     */
    void goodStyleDelet(Long id);

    /**
     * 货物新增
     * @param goodstype
     */
    @Insert("INSERT INTO goodstype  (id,name,remark,create_time,update_time)"
            + "values" + "(#{id},#{name},#{remark},#{createTime}，#{updateTime}) ")
    void addgoodStyle(Goodstype goodstype);
}
