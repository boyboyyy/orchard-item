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
public class HarvestRecord implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 树木ID
     */
    private Long treeId;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 操作员ID
     */
    private Long operatorId;

    /**
     * 收获时间
     */
    private LocalDateTime harvestTime;
}
