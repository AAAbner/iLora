package com.thingcom.demo.service.Impl;

import com.thingcom.demo.common.ResponseCode;
import com.thingcom.demo.common.ServerResponse;
import com.thingcom.demo.constant.Const;
import com.thingcom.demo.dao.IloraUserMapper;
import com.thingcom.demo.dataobject.IloraUser;
import com.thingcom.demo.exception.MyException;
import com.thingcom.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService{

    @Autowired
    private IloraUserMapper userMapper;

    @Override
    public ServerResponse<String> register(IloraUser user) {
        //1.注册时，需要校验用户名是否已存在
        ServerResponse vaildResponse = checkVaild(user.getUsername(),Const.USERNAME);
        if(!vaildResponse.isSuccess()){
            return vaildResponse;
        }
        //2.注册时，需要校验邮箱是否已存在
        vaildResponse = checkVaild(user.getEmail(),Const.EMAIL);
        if(!vaildResponse.isSuccess()){
            return vaildResponse;
        }
        //3.注册时，需要校验手机号是否已存在
        vaildResponse = checkVaild(user.getPhone(),Const.PHONE);
        if(!vaildResponse.isSuccess()){
            return vaildResponse;
        }
        //如果可以注册该用户,为普通用户
        user.setRole(Const.Role.ROLE_ORDIN.getCode());
        int resultCount = userMapper.insert(user);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse checkVaild(String str, String type) {
        if(type!=null && type.length() > 0){
            if(type.equals(Const.USERNAME)){
                int resultCount = userMapper.checkUsername(str);
                if(resultCount > 0){
                    //用户已存在
                    //throw new MyException(ResponseCode.USEREXIT);
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            if(type.equals(Const.EMAIL)) {
                int resultCount = userMapper.checkEmail(str);
                if (resultCount > 0) {
                    //邮箱已存在
                    return ServerResponse.createByErrorMessage("邮箱已存在");
                }
            }
            if(type.equals(Const.PHONE)) {
                int resultCount = userMapper.checkPhone(str);
                if (resultCount > 0) {
                    //手机号已存在
                    return ServerResponse.createByErrorMessage("手机号已存在");
                }
            }
        }
        else {
            //参数不合法
            return ServerResponse.createByErrorMessage("参数不合法");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }
}


