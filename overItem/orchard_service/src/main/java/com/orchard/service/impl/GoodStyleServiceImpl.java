package com.orchard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.context.BaseContext;
import com.orchard.dto.GoodStyleDTO;
import com.orchard.dto.GoodStylePageQueryDTO;
import com.orchard.entity.Goodstype;
import com.orchard.mapper.GoodStyleMapper;
import com.orchard.result.PageResult;
import com.orchard.service.GoodStyleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GoodStyleServiceImpl implements GoodStyleService {
    /**
     * 返回所有的货物数据
     *
     * @return
     */
    @Override
    public List<Goodstype> pageAll() {

        return goodStyleMapper.pageAll();
    }
    @Autowired
    private GoodStyleMapper goodStyleMapper;
    /**
     * 货物分类查询
     *
     * @param goodStylePageQueryDTO
     * @return
     */
    @Override
    public PageResult goodStylePageQuery(GoodStylePageQueryDTO goodStylePageQueryDTO) {
         PageHelper.startPage(goodStylePageQueryDTO.getPageNumber(), goodStylePageQueryDTO.getPageSize() );
         Page<Goodstype> page = goodStyleMapper.goodsPageQusery(goodStylePageQueryDTO);
         long total = page.getTotal();
         List<Goodstype> records = page.getResult();
         //返回给前端
        return new PageResult(total,records) ;
    }

    /**
     * 根据货物分类id查询货物分裂
     *
     * @param id
     * @return
     */
    @Override
    public Goodstype goodStyleById(Long id) {
      Goodstype goodstype =   goodStyleMapper.goodStyleById(id);
        return goodstype;
    }

    /**
     * 货物分类修改数据
     * @param goodStyleDTO
     */
    @Override
    public void goodStyleUpdate(GoodStyleDTO goodStyleDTO) {
        Goodstype goodstype = new Goodstype();
        BeanUtils.copyProperties(goodStyleDTO,goodstype);
        goodstype.setUpdateUser(BaseContext.getCurrentId());
        goodstype.setUpdateTime(LocalDateTime.now());
        goodStyleMapper.updateGoodStyle(goodstype);
    }

    /**
     * 货物类型的新增
     * @param goodStyleDTO
     */
    @Override
    public void addgoodStyle(GoodStyleDTO goodStyleDTO) {
        Goodstype goodstype = new Goodstype();

        BeanUtils.copyProperties(goodStyleDTO,goodstype);
        goodstype.setCreateTime(LocalDateTime.now());
        goodstype.setCreateUser(BaseContext.getCurrentId());
        goodStyleMapper.addgoodStyle(goodstype);
    }

    /**
     * 货物分裂的删除
     * @param id
     */
    @Override
    public void goodStyleDelet(Long id) {
        goodStyleMapper.goodStyleDelet(id);
    }
}
