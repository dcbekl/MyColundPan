package com.easypan.testDao;

/**
 * @Author: lkl
 * @Date: 2023/10/17 11:57
 * @Description:
 **/

public class TestUserDao{

    public void findAllUsers(){
        System.out.println("UserDao 查询所有用户");
    }

    public String findUsernameById(int id){
        System.out.println("UserDao 根据ID查询用户");
        return "公众号：程序新视界";
    }
}