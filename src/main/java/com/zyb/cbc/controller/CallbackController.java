package com.zyb.cbc.controller;

import com.zyb.cbc.service.ICallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * javadoc CallbackController
 * <p>
 *     callback ctrl
 * <p>
 * @author zhang yebai
 * @date 2021/6/10 5:12 PM
 * @version 1.0.0
 **/
@RestController
@RequestMapping(value ="/callback")
public class CallbackController {

    private ICallbackService callbackService;
    @Autowired
    public CallbackController setCallbackService(ICallbackService callbackService) {
        this.callbackService = callbackService;
        return this;
    }

    /**
     * javadoc get
     * @apiNote GET CALLBACK
     *
     * @param configId config id
     * @param request http request
     * @return java.lang.Object
     * @author zhang yebai
     * @date 2021/6/10 8:26 PM
     **/
    @GetMapping(value = "/{configId}")
    public Object get(@PathVariable(value = "configId") String configId, HttpServletRequest request){
        return callbackService.request(configId, request, "");
    }

    /**
     * javadoc post
     * @apiNote POST CALLBACK
     *
     * @param configId config id
     * @param request http request
     * @return java.lang.Object
     * @author zhang yebai
     * @date 2021/6/10 8:26 PM
     **/
    @PostMapping(value = "/{configId}")
    public Object post(@PathVariable(value = "configId") String configId, HttpServletRequest request, @RequestBody String body){
        return callbackService.request(configId, request, body);
    }

    /**
     * javadoc put
     * @apiNote PUT CALLBACK
     *
     * @param configId config id
     * @param request http request
     * @return java.lang.Object
     * @author zhang yebai
     * @date 2021/6/10 8:26 PM
     **/
    @PutMapping(value = "/{configId}")
    public Object put(@PathVariable(value = "configId") String configId, HttpServletRequest request, @RequestBody String body){
        return callbackService.request(configId, request, body);
    }
}
