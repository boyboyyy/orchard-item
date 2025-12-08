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
public class PestRecord implements Serializable {
    /**
     * 主键ID（自增长）
     */
    private Long id;

    /**
     * 树木ID（非空）
     */
    private Long treeId;

    /**
     * 病虫害类型
     */
    private String pestType;

    /**
     * 严重程度
     */
    private String severity;

    /**
     * 处理方法
     */
    private String handleMethod;

    /**
     * 记录时间
     */
    private LocalDateTime recordTime;
}
