package com.orchard.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Excel的数据格式")
public class RecordExcelVo implements Serializable {
    @ApiModelProperty("货物名")
    private  String goodsName;
    @ApiModelProperty("仓库名")
    private  String storageName;
    @ApiModelProperty("货物类型")
    private  String goodstypeName;
    @ApiModelProperty("创建时间")  // 新增字段
    private Date createTime;
    @ApiModelProperty("数量")
    private  Integer count;
    @ApiModelProperty("记录")
    private  String remark;
    @ApiModelProperty("操作人")
    private  String adminName;
    @ApiModelProperty("申请人")
    private  String userName;
}
