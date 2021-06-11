package com.zyb.cbc.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * javadoc QueryTypeEnum
 * <p>
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:52 PM
 * @version 1.0.0
 **/
@Getter
@AllArgsConstructor
public enum QueryTypeEnum {

    /**
     * 丢弃header
     **/
    DEPRECATED(0),

    /**
     * 包含header
     **/
    CONTAINS(1),
    ;

    private final int type;
}
