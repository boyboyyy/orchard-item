package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "收获记录的分页数据")
public class HarvestRecordPageQueryDTO {


    @ApiModelProperty("页码")
    //页码
    private Integer pageNumber;

    @ApiModelProperty("每页显示记录数")
    //每页显示记录数
    private Integer pageSize;
}
