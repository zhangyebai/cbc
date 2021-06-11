package com.zyb.cbc.service;


import com.zyb.cbc.bean.vo.ConfigVo;

/**
 * javadoc IConfigService
 * <p>
 *     config service
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 7:58 PM
 * @version 1.0.0
 **/
public interface IConfigService {

    /**
     * javadoc add
     * @apiNote
     *
     * @param vo config
     * @return com.zyb.cbc.bean.vo.ConfigVo
     * @author zhang yebai
     * @date 2021/6/10 8:11 PM
     **/
    ConfigVo add(ConfigVo vo);

    /**
     * javadoc find
     * @apiNote
     *
     * @param configId unique id of config
     * @return com.zyb.cbc.bean.vo.ConfigVo
     * @author zhang yebai
     * @date 2021/6/10 8:12 PM
     **/
    ConfigVo find(String configId);

    /**
     * javadoc update
     * @apiNote
     *
     * @param vo config
     * @return com.zyb.cbc.bean.vo.ConfigVo
     * @author zhang yebai
     * @date 2021/6/10 8:14 PM
     **/
    ConfigVo update(ConfigVo vo);

    /**
     * javadoc delete
     * @apiNote
     *
     * @param vo config
     * @return com.zyb.cbc.bean.vo.ConfigVo
     * @author zhang yebai
     * @date 2021/6/10 8:21 PM
     **/
    ConfigVo delete(ConfigVo vo);
}
