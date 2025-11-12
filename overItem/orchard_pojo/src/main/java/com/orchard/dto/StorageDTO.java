package com.orchard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(description = "仓库新增参数")
@Data
public class StorageDTO implements Serializable {
    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("记录")
    private String remark;

    @ApiModelProperty("仓库名字")
    private String name;


}
