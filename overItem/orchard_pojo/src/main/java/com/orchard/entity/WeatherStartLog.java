package com.orchard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherStartLog  implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 日志类型：1=天气，2=库存统计，3=操作日志
     */
    private Integer logType;

    /**
     * 温度
     */
    private BigDecimal temperature;

    /**
     * 湿度
     */
    private BigDecimal humidity;

    /**
     * 降雨量
     */
    private BigDecimal rainfall;

    /**
     * 风速
     */
    private BigDecimal windSpeed;

    /**
     * 天气数据来源
     */
    private String weatherSource;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 库存总数
     */
    private Integer totalCount;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 操作动作
     */
    private String action;

    /**
     * 操作详情
     */
    private String detail;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
