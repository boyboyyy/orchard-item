package com.orchard.entity;

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
public class TreeInfo implements Serializable {
    private Long id;
    private Long areaId;
    private Long typeId;
    private LocalDateTime plantDate;
    private String healthStatus;
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
