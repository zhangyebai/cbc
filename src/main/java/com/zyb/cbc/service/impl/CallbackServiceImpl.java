package com.zyb.cbc.service.impl;

import com.google.common.collect.Maps;
import com.zyb.cbc.bean.Message;
import com.zyb.cbc.bean.entity.ConfigEntity;
import com.zyb.cbc.bean.entity.ErrorEntity;
import com.zyb.cbc.bean.enums.HeaderTypeEnum;
import com.zyb.cbc.bean.enums.QueryTypeEnum;
import com.zyb.cbc.bean.enums.ReturnTypeEnum;
import com.zyb.cbc.processor.IConfigProcessor;
import com.zyb.cbc.processor.IErrorProcessor;
import com.zyb.cbc.service.ICallbackService;
import com.zyb.cbc.utils.JsonUtil;
import com.zyb.cbc.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * javadoc CallbackServiceImpl
 * <p>
 *     call back service impl
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:13 PM
 * @version 1.0.0
 **/
@Service
@Slf4j
public class CallbackServiceImpl implements ICallbackService {

    private IConfigProcessor configProcessor;
    @Autowired
    public CallbackServiceImpl setConfigProcessor(IConfigProcessor configProcessor) {
        this.configProcessor = configProcessor;
        return this;
    }

    private IErrorProcessor errorProcessor;
    @Autowired
    public CallbackServiceImpl setErrorProcessor(IErrorProcessor errorProcessor) {
        this.errorProcessor = errorProcessor;
        return this;
    }

    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    public CallbackServiceImpl setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        return this;
    }



    @Override
    public Object sync(ConfigEntity entity, HttpServletRequest request, String body) {
        try {
            final var message = new Message()
                    .setHeaders(headers(request, entity))
                    .setParams(params(request, entity))
                    .setBody(body)
                    .setTs(System.currentTimeMillis())
                    ;
            kafkaTemplate.send(entity.getTopic(), JsonUtil.toJsonString(message));
            return returnValue(entity, true);
        }catch (Exception ex){
            log.error("sync({}, request, {}) exception: ", entity, body);
            final var message = Maps.newHashMap();
            message.put("config", entity);
            message.put("body", body);
            errorProcessor.save(new ErrorEntity().setBizType(0).setCts(LocalDateTime.now()).setErrorMessage(ex.getMessage()).setMessage(JsonUtil.toJsonString(message)));
        }
        return returnValue(entity, false);
    }

    @Override
    @Deprecated
    @Async(value = "asyncTaskExecutor")
    public void async(ConfigEntity entity, HttpServletRequest request, String body) {
        try {
            final var message = new Message()
                    .setHeaders(headers(request, entity))
                    .setParams(params(request, entity))
                    .setBody(body)
                    .setTs(System.currentTimeMillis())
                    ;
            kafkaTemplate.send(entity.getTopic(), JsonUtil.toJsonString(message));
        }catch (Exception ex){
            final var message = Maps.newHashMap();
            message.put("config", entity);
            message.put("body", body);
            errorProcessor.save(new ErrorEntity().setBizType(0).setCts(LocalDateTime.now()).setErrorMessage(ex.getMessage()).setMessage(JsonUtil.toJsonString(message)));
        }
    }

    @Override
    public Object request(String configId, HttpServletRequest request, String body) {
        try {
            final var entity = configProcessor.findByConfigId(configId).orElseThrow(() -> new RuntimeException("无法找到对应的配置"));
            return sync(entity, request, body);
        }catch (Exception ex){
            final var message = Maps.newHashMap();
            message.put("configId", configId);
            message.put("body", body);
            errorProcessor.save(new ErrorEntity().setBizType(0).setCts(LocalDateTime.now()).setErrorMessage(ex.getMessage()).setMessage(JsonUtil.toJsonString(message)));
        }
        return null;
    }

    private Object returnValue(ConfigEntity entity, boolean success){
        return ReturnTypeEnum.value(entity.getReturnType(), success ? entity.getOkReturnValue() : entity.getErrorReturnValue());
    }

    private String headers(HttpServletRequest request, ConfigEntity entity){
        if(entity.getHeaderType() == HeaderTypeEnum.CONTAINS.getType()){
            return JsonUtil.toJsonString(RequestUtil.headers(request));
        }
        return null;
    }

    private String params(HttpServletRequest request, ConfigEntity entity){
        if(entity.getQueryType() == QueryTypeEnum.CONTAINS.getType()){
            return JsonUtil.toJsonString(RequestUtil.params(request));
        }
        return null;
    }
}
