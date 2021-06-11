package com.zyb.cbc.processor.impl;

import com.zyb.cbc.bean.annotations.Processor;
import com.zyb.cbc.bean.entity.ConfigEntity;
import com.zyb.cbc.processor.IConfigProcessor;
import com.zyb.cbc.processor.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * javadoc ConfigProcessorImpl
 * <p>
 *     config processor
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:05 PM
 * @version 1.0.0
 **/
@Processor
public class ConfigProcessorImpl implements IConfigProcessor {

    private ConfigRepository repository;
    @Autowired
    public ConfigProcessorImpl setRepository(ConfigRepository repository) {
        this.repository = repository;
        return this;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ConfigEntity save(ConfigEntity entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ConfigEntity update(ConfigEntity entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void delete(String configId) {
        repository.deleteByConfigId(configId);
    }

    @Override
    public List<ConfigEntity> list() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Stream<ConfigEntity> stream() {
        return list().stream();
    }

    @Override
    public Optional<ConfigEntity> findByConfigId(String configId) {
        return repository.findByConfigId(configId);
    }
}
