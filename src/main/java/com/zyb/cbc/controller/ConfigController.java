package com.zyb.cbc.controller;

import com.zyb.cbc.bean.vo.ConfigVo;
import com.zyb.cbc.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * javadoc ConfigController
 * <p>
 *
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 7:52 PM
 * @version 1.0.0
 **/
@RestController
@RequestMapping(value = "/system")
public class ConfigController {

    private IConfigService configService;
    @Autowired
    public ConfigController setConfigService(IConfigService configService) {
        this.configService = configService;
        return this;
    }

    /**
     * javadoc add
     * @apiNote 新增
     *
     * @param vo config
     * @return com.zyb.cbc.bean.vo.ConfigVo
     * @author zhang yebai
     * @date 2021/6/10 8:22 PM
     **/
    @PostMapping(value = "/config")
    public ConfigVo add(@RequestBody ConfigVo vo){
        return configService.add(vo);
    }

    /**
     * javadoc find
     * @apiNote 查询
     *
     * @param configId unique id of config
     * @return com.zyb.cbc.bean.vo.ConfigVo
     * @author zhang yebai
     * @date 2021/6/10 8:23 PM
     **/
    @GetMapping(value = "/config/{configId}")
    public ConfigVo find(@PathVariable(value = "configId") String configId){
        return configService.find(configId);
    }

    /**
     * javadoc update
     * @apiNote
     *
     * @param vo 更新
     * @return com.zyb.cbc.bean.vo.ConfigVo
     * @author zhang yebai
     * @date 2021/6/10 8:23 PM
     **/
    @PutMapping(value = "/config")
    public ConfigVo update(@RequestBody ConfigVo vo){
        return configService.update(vo);
    }

    /**
     * javadoc delete
     * @apiNote 删除
     *
     * @param vo config
     * @return com.zyb.cbc.bean.vo.ConfigVo
     * @author zhang yebai
     * @date 2021/6/10 8:23 PM
     **/
    @DeleteMapping(value = "/config")
    public ConfigVo delete(@RequestBody ConfigVo vo){
        return configService.delete(vo);
    }
}
