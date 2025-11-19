package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(description = "记录新增参数")
public class RecordDTO implements Serializable {


    @ApiModelProperty("记录")
    private String remark;
    @ApiModelProperty("货物名字")
    private Integer goods;
    @ApiModelProperty("申请人名字")
    private Integer userId;
    @ApiModelProperty("管理员名字")
    private Integer adminId;
    @ApiModelProperty("货物数量")
    private Integer count;
}
