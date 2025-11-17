package com.orchard.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "仓库修改返回的数据格式")
public class GoodsFixVo implements Serializable  {
    /**
     * 主键（根据表结构推断）
     */
    private Integer id;

    /**
     * 货品名称
     */
    private String name;

    /**
     * 仓库/库存地点
     */
    private String storage;

    /**
     * 货品类型
     */
    private String goodsType;

    /**
     * 库存数量
     */
    private Integer count;

    /**
     * 备注
     */
    private String remark;

    /**
     * 开始创建人
     */
    private String createUser;
    /**
     * 修改创建人
     */
    private String updateUser;
}
