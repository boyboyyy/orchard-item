package com.orchard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class treeEventRecord implements Serializable {

        /**
         * 主键ID
         */
        private Long id;

        /**
         * 树木ID
         */
        private Long treeId;

        /**
         * 事件类型: 1=生长, 2=施肥, 3=灌溉, 4=修剪, 5=其他
         */
        private Integer eventType;

        /**
         * 树高(米)
         */
        private BigDecimal height;

        /**
         * 胸径(厘米)
         */
        private BigDecimal diameter;

        /**
         * 事件描述
         */
        private String eventDesc;

        /**
         * 用量/数量
         */
        private BigDecimal amount;

        /**
         * 操作员ID
         */
        private Long operatorId;

        /**
         * 备注
         */
        private String notes;

        /**
         * 记录时间
         */
        private LocalDateTime recordTime;

}
