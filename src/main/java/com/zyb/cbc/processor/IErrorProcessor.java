package com.zyb.cbc.processor;

import com.zyb.cbc.bean.entity.ErrorEntity;

/**
 * javadoc IErrorProcessor
 * <p>
 *     error processor
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:10 PM
 * @version 1.0.0
 **/
@SuppressWarnings(value = "UnusedReturnValue")
public interface IErrorProcessor {

    /**
     * javadoc save
     * @apiNote
     *
     * @param entity runtime error
     * @return com.zyb.cbc.bean.entity.ErrorEntity
     * @author zhang yebai
     * @date 2021/6/10 5:10 PM
     **/
    ErrorEntity save(ErrorEntity entity);
}
