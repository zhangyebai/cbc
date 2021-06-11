package com.zyb.cbc.processor.impl;

import com.zyb.cbc.bean.annotations.Processor;
import com.zyb.cbc.bean.entity.ErrorEntity;
import com.zyb.cbc.processor.IErrorProcessor;
import com.zyb.cbc.processor.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * javadoc ErrorProcessorImpl
 * <p>
 *     runtime error processor impl
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:11 PM
 * @version 1.0.0
 **/
@Processor
public class ErrorProcessorImpl implements IErrorProcessor {

    private ErrorRepository repository;
    @Autowired
    public ErrorProcessorImpl setRepository(ErrorRepository repository) {
        this.repository = repository;
        return this;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ErrorEntity save(ErrorEntity entity) {
        return repository.save(entity);
    }
}
