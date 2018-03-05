package com.thingcom.demo.service;

import com.thingcom.demo.common.ServerResponse;
import com.thingcom.demo.dataobject.IloraUser;

public interface IUserService {

    //用户注册API
    ServerResponse<String> register(IloraUser iloraUser);

    //根据传进来的String变量，查询用户名、手机号、邮箱是否存在
    ServerResponse checkVaild(String str,String type);
}
