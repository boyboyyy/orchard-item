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

import java.util.List;

@Mapper
public interface GoodStyleMapper {
    /**
     * 返回所有货物的数据
     * @return
     */
    List<Goodstype> pageAll();
    /**
     * 通过货物名称获取货物分类id
     * @param name
     * @return
     */
//    Integer goodStypeIdBygoodName(String name);

    /**
     * 货物分类查询
     * @param goodStylePageQueryDTO
     * @return
     */
    Page<Goodstype> goodsPageQusery(GoodStylePageQueryDTO goodStylePageQueryDTO);

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
    Goodstype goodStyleById(Long id);

    /**
     * 根据id删除货物分类
     * @param id
     */
    void goodStyleDelet(Long id);

    /**
     * 货物新增
     * @param goodstype
     */
    @Insert("INSERT INTO goodstype  (id,name,remark,create_time,create_user)"
            + "values" + "(#{id},#{name},#{remark},#{createTime},#{createUser}) ")
    void addgoodStyle(Goodstype goodstype);
}
