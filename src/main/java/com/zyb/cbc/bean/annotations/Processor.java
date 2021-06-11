package com.zyb.cbc.bean.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * javadoc Processor
 * <p>
 *     orm 数据处理器封装component
 * <p>
 * @author zhang yebai
 * @date 2021/1/6 6:49 PM
 * @version 1.0.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
@SuppressWarnings(value = {"UnusedReturnValue", "unused"})
public @interface Processor {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
