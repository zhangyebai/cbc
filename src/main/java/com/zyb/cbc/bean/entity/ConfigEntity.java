package com.zyb.cbc.bean.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * javadoc ConfigEntity
 * <p>
 *     配置列表
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 4:52 PM
 * @version 1.0.0
 **/
@Data
@Accessors(chain = true)
@Table(name = "t_config")
@Entity
public class ConfigEntity implements Serializable {

    private static final long serialVersionUID = -33296395481609010L;

    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 配置id
     */
    private String configId;

    /**
     * kafka topic
     */
    private String topic;

    /**
     * 请求header类型
     **/
    private Integer headerType;

    /**
     * 请求query 类型
     **/
    private Integer queryType;

    /**
     * 返回值类型
     */
    private Integer returnType;

    /**
     * 正常返回值
     */
    private String okReturnValue;

    /**
     * 错误返回值
     */
    private String errorReturnValue;

    /**
     * 备注
     **/
    private String comments;

    /**
     * 创建时间
     */
    private LocalDateTime cts;

    /**
     * 更新时间
     */
    private LocalDateTime uts;
}
