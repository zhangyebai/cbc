package com.zyb.cbc.converter;

import com.zyb.cbc.bean.entity.ConfigEntity;
import com.zyb.cbc.bean.vo.ConfigVo;
import com.zyb.cbc.utils.IdUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * javadoc ConfigConverter
 * <p>
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 7:59 PM
 * @version 1.0.0
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigConverter {

    public static ConfigEntity vo2entity(@NonNull ConfigVo vo){
        final var now = LocalDateTime.now();
        return new ConfigEntity()
                .setConfigId(IdUtils.balancedId())
                .setTopic(vo.getTopic())
                .setHeaderType(vo.getHeaderType())
                .setQueryType(vo.getQueryType())
                .setReturnType(vo.getReturnType())
                .setOkReturnValue(vo.getOkReturnValue())
                .setErrorReturnValue(vo.getErrorReturnValue())
                .setComments(vo.getComments())
                .setCts(now)
                .setUts(now)
                ;
    }

    public static ConfigVo entity2vo(@NonNull ConfigEntity entity){
        return new ConfigVo()
                .setId(entity.getId())
                .setConfigId(entity.getConfigId())
                .setTopic(entity.getTopic())
                .setHeaderType(entity.getHeaderType())
                .setQueryType(entity.getQueryType())
                .setReturnType(entity.getReturnType())
                .setOkReturnValue(entity.getOkReturnValue())
                .setErrorReturnValue(entity.getErrorReturnValue())
                .setComments(entity.getComments())
                .setCts(entity.getCts())
                .setUts(entity.getUts())
                ;
    }

    public static ConfigEntity update(@NonNull ConfigEntity entity, @NonNull ConfigVo vo){
        if(StringUtils.isNotBlank(vo.getTopic())){
            entity.setTopic(vo.getTopic());
        }

        if(Objects.nonNull(vo.getHeaderType())){
            entity.setHeaderType(vo.getHeaderType());
        }

        if(Objects.nonNull(vo.getQueryType())){
            entity.setQueryType(vo.getQueryType());
        }

        if(Objects.nonNull(vo.getReturnType())){
            entity.setReturnType(vo.getReturnType());
        }

        if(StringUtils.isNotBlank(vo.getOkReturnValue())){
            entity.setOkReturnValue(vo.getOkReturnValue());
        }

        if(StringUtils.isNotBlank(vo.getErrorReturnValue())){
            entity.setErrorReturnValue(vo.getErrorReturnValue());
        }

        if(StringUtils.isNotBlank(vo.getComments())){
            entity.setComments(vo.getComments());
        }

        return entity.setUts(LocalDateTime.now());
    }
}
