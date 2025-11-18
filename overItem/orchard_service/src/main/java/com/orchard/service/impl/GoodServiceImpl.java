package com.orchard.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orchard.context.BaseContext;
import com.orchard.dto.GoodDTO;
import com.orchard.dto.GoodPageQueryDTO;
import com.orchard.entity.Goods;
import com.orchard.mapper.GoodMapper;
import com.orchard.mapper.GoodStyleMapper;
import com.orchard.mapper.StorageMapper;
import com.orchard.result.PageResult;
import com.orchard.service.GoodService;
import com.orchard.service.StorageService;
import com.orchard.vo.GoodsFixVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
//    @Autowired
//    private StorageMapper storageMapper;
//    @Autowired
//    private GoodStyleMapper goodStyleMapper;
    /**
     * 货物分类查询
     *
     * @param goodPageQueryDTO
     * @return
     */
    @Override
    public PageResult goodPageQuery(GoodPageQueryDTO goodPageQueryDTO) {
        PageHelper.startPage(goodPageQueryDTO.getPageNumber(), goodPageQueryDTO.getPageSize() );
        Page<GoodsFixVo> page = goodMapper.goodsPageQusery(goodPageQueryDTO);
        long total = page.getTotal();
        List<GoodsFixVo> records = page.getResult();
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
    public GoodsFixVo goodById(Long id) {
        GoodsFixVo goodsFixVo =   goodMapper.goodById(id);
        return goodsFixVo;
    }

    /**
     * 货物分类修改数据
     * @param goodDTO
     */
//    @Override
//    public void goodUpdate(GoodDTO goodDTO) {
//        //获取仓库的id
//        Integer storageId =  storageMapper.goodsByName(goodDTO.getStorage());
//        Integer goodstypeId =  goodStyleMapper.goodStypeIdBygoodName(goodDTO.getGoodsType());
//
//        Goods goods = new Goods().builder()
//                .id(goodDTO.getId())
//                .name(goodDTO.getName())
//                .storage(storageId)
//                .goodsType(goodstypeId)
//                .createUser(BaseContext.getCurrentId())
//                .createTime(LocalDateTime.now())
//                .remark(goodDTO.getRemark())
//                .count(goodDTO.getCount())
//                .build();
//        goodMapper.updateGood(goods);
//    }

    /**
     * 货物分裂的删除
     * @param id
     */
    @Override
    public void goodDelet(Long id) {
        goodMapper.goodDelet(id);
    }

    /**
     * 货物新增
     * @param goodDTO
     */
//    @Override
//    public void addgood(GoodDTO goodDTO) {
//
////        goodMapper.addgood(goods);
//    }
}
