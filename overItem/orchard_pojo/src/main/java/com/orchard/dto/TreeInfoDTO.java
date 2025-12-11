package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "树木新增参数")
public class TreeInfoDTO implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("区域id")
    private Long areaId;

    @ApiModelProperty("货物类型")
    private Long typeId;

    @ApiModelProperty("种植时间")
    private LocalDateTime plantDate;

    @ApiModelProperty("健康状态")
    private String healthStatus;

    @ApiModelProperty("记录")
    private String remark;

    @ApiModelProperty("树木名")
    private String name;

}
