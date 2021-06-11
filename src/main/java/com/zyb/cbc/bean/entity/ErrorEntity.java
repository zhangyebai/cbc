package com.zyb.cbc.bean.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * javadoc ErrorEntity
 * <p>
 *     runtime error entity
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:01 PM
 * @version 1.0.0
 **/
@Data
@Accessors(chain = true)
@Table(name = "t_error")
@Entity
public class ErrorEntity implements Serializable {
    private static final long serialVersionUID = -81539108064613396L;

    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 错误消息
     **/
    private String errorMessage;

    /**
     * 业务类型代码
     */
    private Integer bizType;

    /**
     * 消息时间
     */
    private LocalDateTime cts;
}
