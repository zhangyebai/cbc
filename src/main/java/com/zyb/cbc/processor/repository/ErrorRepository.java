package com.zyb.cbc.processor.repository;

import com.zyb.cbc.bean.entity.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * javadoc ErrorRepository
 * <p>
 *     error repository
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:10 PM
 * @version 1.0.0
 **/
@Repository
public interface ErrorRepository extends JpaRepository<ErrorEntity, Long>, JpaSpecificationExecutor<ErrorEntity> {
}
