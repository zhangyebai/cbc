package com.zyb.cbc.service;

import com.zyb.cbc.bean.entity.ConfigEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * javadoc ICallbackService
 * <p>
 *     call back service
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:13 PM
 * @version 1.0.0
 **/
public interface ICallbackService {


    /**
     * javadoc sync
     * @apiNote
     *
     * @param entity  config
     * @param request http request
     * @param body request body
     * @return java.lang.Object
     * @author zhang yebai
     * @date 2021/6/10 8:33 PM
     **/
    Object sync(ConfigEntity entity, HttpServletRequest request, String body);

    /**
     * javadoc async
     * @apiNote
     *
     * @param entity config
     * @param request http request
     * @param body request body
     * @author zhang yebai
     * @date 2021/6/10 8:33 PM
     * @deprecated HttpServletRequest not apply for raw async
     * @since now
     **/
    @Deprecated(since = "now")
    void async(ConfigEntity entity, HttpServletRequest request, String body);

    /**
     * javadoc request
     * @apiNote
     *
     * @param configId unique id
     * @param request 请求
     * @param body 请求body
     * @return java.lang.Object
     * @author zhang yebai
     * @date 2021/6/10 5:41 PM
     **/
    Object request(String configId, HttpServletRequest request, String body);
}
