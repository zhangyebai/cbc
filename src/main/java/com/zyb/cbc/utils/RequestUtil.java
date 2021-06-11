package com.zyb.cbc.utils;

import com.google.common.collect.Maps;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * javadoc RequestUtil
 * <p>
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:48 PM
 * @version 1.0.0
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestUtil {

    /**
     * javadoc headers
     * @apiNote list all headers in http request
     *
     * @param request http request
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author zhang yebai
     * @date 2021/6/10 5:50 PM
     **/
    public static Map<String, Object> headers(HttpServletRequest request){
        final Map<String, Object> headers = Maps.newHashMap();
        request.getAttributeNames().asIterator().forEachRemaining(n -> headers.put(n, request.getAttribute(n)));
        return headers;
    }


    /**
     * javadoc params
     * @apiNote list all query params in http request
     *
     * @param request http request
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author zhang yebai
     * @date 2021/6/10 5:51 PM
     **/
    public static Map<String, Object> params(HttpServletRequest request){
        final Map<String, Object> headers = Maps.newHashMap();
        request.getParameterNames().asIterator().forEachRemaining(n -> headers.put(n, request.getParameter(n)));
        return headers;
    }
}
