package com.orchard.entity;

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
public class Goods implements Serializable {
    /**
     * 主键（根据表结构推断）
     */
    private Long id;

    /**
     * 货品名称
     */
    private String name;

    /**
     * 仓库/库存地点
     */
    private Integer storage;

    /**
     * 货品类型
     */
    private Integer goodsType;

    /**
     * 库存数量
     */
    private Integer count;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 开始创建人
     */
    private Long createUser;
    /**
     * 修改创建人
     */
    private Long updateUser;
}
