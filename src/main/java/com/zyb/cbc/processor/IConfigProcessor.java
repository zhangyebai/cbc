package com.zyb.cbc.processor;

import com.zyb.cbc.bean.entity.ConfigEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * javadoc IConfigProcessor
 * <p>
 *     config processor
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 4:54 PM
 * @version 1.0.0
 **/
public interface IConfigProcessor {

    /**
     * javadoc save
     * @apiNote
     *
     * @param entity config
     * @return com.zyb.cbc.bean.entity.ConfigEntity
     * @author zhang yebai
     * @date 2021/6/10 5:03 PM
     **/
    ConfigEntity save(ConfigEntity entity);

    /**
     * javadoc update
     * @apiNote
     *
     * @param entity config
     * @return com.zyb.cbc.bean.entity.ConfigEntity
     * @author zhang yebai
     * @date 2021/6/10 5:03 PM
     **/
    ConfigEntity update(ConfigEntity entity);

    /**
     * javadoc delete
     * @apiNote
     *
     * @param configId config unique id
     * @author zhang yebai
     * @date 2021/6/10 5:03 PM
     **/
    void delete(String configId);

    /**
     * javadoc list
     * @apiNote all configs order by id asc
     *
     * @return java.util.List<com.zyb.cbc.bean.entity.ConfigEntity>
     * @author zhang yebai
     * @date 2021/6/10 5:03 PM
     **/
    List<ConfigEntity> list();

    /**
     * javadoc stream
     * @apiNote all configs stream order by id desc
     *
     * @return java.util.stream.Stream<com.zyb.cbc.bean.entity.ConfigEntity>
     * @author zhang yebai
     * @date 2021/6/10 5:03 PM
     **/
    Stream<ConfigEntity> stream();

    /**
     * javadoc findByConfigId
     * @apiNote
     *
     * @param configId config unique id
     * @return java.util.Optional<com.zyb.cbc.bean.entity.ConfigEntity>
     * @author zhang yebai
     * @date 2021/6/10 5:04 PM
     **/
    Optional<ConfigEntity> findByConfigId(String configId);
}
