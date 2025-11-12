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
public class Storage implements Serializable    {
    private Long id;
    private String name;
    private String remark;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 开始创建人
     */
    private Long createUser;
    /**
     * 修改创建人
     */
    private Long updateUser;
}
