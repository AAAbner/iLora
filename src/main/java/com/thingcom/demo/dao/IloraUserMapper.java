package com.thingcom.demo.dao;

import com.thingcom.demo.dataobject.IloraUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IloraUserMapper {


    int deleteByPrimaryKey(Integer id);


    int insert(IloraUser record);


    IloraUser selectByPrimaryKey(Integer id);


    List<IloraUser> selectAll();


    int updateByPrimaryKey(IloraUser record);


    //检查用户名是否存在
    int checkUsername(String username);
    //检查邮箱是否存在
    int checkEmail(String email);
    //检查电话是否存在
    int checkPhone(String phone);



}