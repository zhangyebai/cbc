package com.zyb.cbc.processor.repository;

import com.zyb.cbc.bean.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * javadoc ConfigRepository
 * <p>
 *     config repository
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 4:55 PM
 * @version 1.0.0
 **/
@Repository
public interface ConfigRepository extends JpaRepository<ConfigEntity, Long>, JpaSpecificationExecutor<ConfigEntity> {

    /**
     * javadoc deleteByConfigId
     * @apiNote
     *
     * @param configId unique id
     * @author zhang yebai
     * @date 2021/6/10 5:06 PM
     **/
    void deleteByConfigId(String configId);


    /**
     * javadoc findByConfigId
     * @apiNote
     *
     * @param configId unique id
     * @return java.util.Optional<com.zyb.cbc.bean.entity.ConfigEntity>
     * @author zhang yebai
     * @date 2021/6/10 5:08 PM
     **/
    Optional<ConfigEntity> findByConfigId(String configId);
}
