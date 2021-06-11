package com.zyb.cbc.bean.enums;

import com.zyb.cbc.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * javadoc ReturnTypeEnum
 * <p>
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:54 PM
 * @version 1.0.0
 **/
@AllArgsConstructor
@Getter
public enum ReturnTypeEnum {
    /**
     * null
     **/
    NULL(0),

    TEXT(1),

    JSON_MAP(2),

    JSON_LIST(3),
    ;
    private final int type;

    /**
     * javadoc value
     * @apiNote generate request return value
     *
     * @param type return type
     * @param returnValue return value string
     * @return java.lang.Object
     * @author zhang yebai
     * @date 2021/6/10 5:58 PM
     **/
    public static Object value(int type, String returnValue){
        switch (type){
            case 1:
                return returnValue;
            case 2:
                return JsonUtil.parseObject(returnValue, Map.class);
            case 3:
                return JsonUtil.parseObject(returnValue, List.class);
            default:
                return null;
        }
    }

}
