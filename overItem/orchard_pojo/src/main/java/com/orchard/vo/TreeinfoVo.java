package com.orchard.vo;

import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "树木数据返回的数据格式")
public class TreeinfoVo implements Serializable {
    private Integer id;
    private String orchardAreaName;
    private String goodsTypeName;
    private LocalDateTime plantDate;
    private String healthStatus;
    private String remark;
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
