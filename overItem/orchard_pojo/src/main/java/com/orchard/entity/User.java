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
public class User implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private String no;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码（存储哈希值）
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别：0-未知,1-男,2-女
     */
    private Integer sex;

    /**
     * 电话
     */
    private String phone;

    /**
     * 角色：0-超级管理员,1-普通用户
     * 注意：您表中注释是"角色：0-超级管理员,1-男"，这里我修正为更合理的角色定义
     */
    private Integer roleId;

    /**
     * 是否有效：Y-有效,N-无效
     */
    private Integer isValid;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
