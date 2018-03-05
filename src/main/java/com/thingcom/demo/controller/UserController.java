package com.thingcom.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.thingcom.demo.common.ServerResponse;
import com.thingcom.demo.dataobject.IloraUser;
import com.thingcom.demo.service.AliyunSMSService;
import com.thingcom.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/iloraPlatform/users")
public class UserController {

    @Autowired
    private IUserService iUserService;


    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ServerResponse register(IloraUser user){
        return iUserService.register(user);
    }

    /**
     * 发送验证码
     * @return
     */
    @RequestMapping(value = "sendsms",method = RequestMethod.POST)
    public ServerResponse sendSms(@RequestParam("phone") String phone){
        try {
            String code =  AliyunSMSService.sendSms(phone);
            JSONObject object = new JSONObject();
            object.put("code",code);
            return ServerResponse.createBySuccessData("短信验证码发送成功",object);

        } catch (ClientException e) {
            return ServerResponse.createByErrorMessage("短信验证码发送失败");
        }
    }


    /**
     * 用户登录API
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ServerResponse login(){


    }
}
