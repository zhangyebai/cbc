package com.zyb.cbc.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * javadoc Message
 * <p>
 *     message content
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:58 PM
 * @version 1.0.0
 **/
@Data
@Accessors(chain = true)
public class Message{

    /**
     * headers, Json.toString()
     **/
    private String headers;

    /**
     * query params, Json.toString()
     **/
    private String params;

    /**
     * request body, any
     **/
    private String body;

    /**
     * timestamp
     **/
    private Long ts;
}
