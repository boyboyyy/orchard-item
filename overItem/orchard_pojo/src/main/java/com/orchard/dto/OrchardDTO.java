package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "地区新增参数")
public class OrchardDTO implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("地域名字")
    private String name;

    @ApiModelProperty("地域创建时间")
    private LocalDateTime createTime;

}
