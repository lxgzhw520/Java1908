package com.lxgzhw.test;

import com.lxgzhw.dao.UserDao;
import com.lxgzhw.login.domain.User;
import org.junit.Test;

/*
测试是否能够访问数据库
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        //1.创建登录用户
        User loginUser = new User();
        loginUser.setUsername("lxgzhw");
        loginUser.setPassword("lxgzhw");

        //2.调用登录方法
        User user = new UserDao().login(loginUser);
        System.out.println(user);
    }
}
