package com.orchard.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "货物数据返回的数据格式")
public class RecordPageVo implements Serializable {

    @ApiModelProperty("主键id")
    private  Long id;
    @ApiModelProperty("货物名")
    private  String goodsName;
    @ApiModelProperty("仓库名")
    private  String storageName;
    @ApiModelProperty("货物类型")
    private  String goodstypeName;
    @ApiModelProperty("数量")
    private  Integer count;
    @ApiModelProperty("记录")
    private  String remark;
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    @ApiModelProperty("操作人")
    private  String adminName;
    @ApiModelProperty("申请人")
    private  String userName;
}
