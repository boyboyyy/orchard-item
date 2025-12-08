package com.orchard.bo;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class RecordExcellBo {

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
