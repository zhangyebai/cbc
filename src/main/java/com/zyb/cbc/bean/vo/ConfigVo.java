package com.zyb.cbc.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * javadoc ConfigVo
 * <p>
 *
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 7:54 PM
 * @version 1.0.0
 **/
@Data
@Accessors(chain = true)
public class ConfigVo {

    /**
     * 自增id
     **/
    private Long id;

    /**
     * 配置unique id
     **/
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
     **/
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime cts;

    /**
     * 更新时间
     **/
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime uts;
}
