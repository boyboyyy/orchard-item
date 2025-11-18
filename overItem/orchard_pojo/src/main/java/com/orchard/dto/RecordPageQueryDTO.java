package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(description = "货物记录的分页数据")
public class RecordPageQueryDTO implements Serializable {
    @ApiModelProperty("货物名")
    //货物姓名
    private String goods;
    @ApiModelProperty("货物类型名")
    //货物姓名
    private String goodsTypeName;
    @ApiModelProperty("仓库名")
    //货物姓名
    private String storageName;

    @ApiModelProperty("页码")
    //页码
    private Integer pageNumber;

    @ApiModelProperty("每页显示记录数")
    //每页显示记录数
    private Integer pageSize;
}
