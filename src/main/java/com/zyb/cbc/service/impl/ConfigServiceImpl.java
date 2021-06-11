package com.zyb.cbc.service.impl;

import com.zyb.cbc.bean.vo.ConfigVo;
import com.zyb.cbc.converter.ConfigConverter;
import com.zyb.cbc.processor.IConfigProcessor;
import com.zyb.cbc.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * javadoc ConfigServiceImpl
 * <p>
 *     config service impl
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 7:59 PM
 * @version 1.0.0
 **/
@Service
public class ConfigServiceImpl implements IConfigService {

    private IConfigProcessor processor;
    @Autowired
    public ConfigServiceImpl setProcessor(IConfigProcessor processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public ConfigVo add(ConfigVo vo) {
        var entity = processor.save(ConfigConverter.vo2entity(vo));
        return vo.setId(entity.getId()).setConfigId(entity.getConfigId()).setCts(entity.getCts()).setUts(entity.getUts());
    }

    @Override
    public ConfigVo find(String configId) {
        return processor.findByConfigId(configId).map(ConfigConverter::entity2vo).orElse(null);
    }

    @Override
    public ConfigVo update(ConfigVo vo) {
        return processor.findByConfigId(vo.getConfigId())
                .map(e -> {
                    final var entity = ConfigConverter.update(e, vo);
                    processor.update(entity);
                    return ConfigConverter.entity2vo(entity);
                })
                .orElse(vo);
    }

    @Override
    public ConfigVo delete(ConfigVo vo) {
        return processor.findByConfigId(vo.getConfigId())
                .map(e -> {
                    processor.delete(e.getConfigId());
                    return ConfigConverter.entity2vo(e);
                })
                .orElse(vo);
    }
}
