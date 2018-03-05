package com.thingcom.demo.dao;


import com.thingcom.demo.dataobject.IloraUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IloraUserMapperTest {

    @Autowired
    private IloraUserMapper userMapper;

    @Test
    public void insert() {
        IloraUser iloraUser = new IloraUser();
        iloraUser.setUsername("陈宇翔");
        iloraUser.setPassword("123456");
        iloraUser.setPhone("15958106223");
        iloraUser.setEmail("849375403@qq.com");
        iloraUser.setCompany("杭州轨物科技有限公司");
        iloraUser.setRole(1);
        System.out.println(userMapper.insert(iloraUser));
//        if(userMapper.insert(iloraUser)>0){
//            System.out.println("插入用户成功");
//        }
//        else {
//            System.out.println("插入用户失败");
//        }




    }
}