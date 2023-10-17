package com.easypan.utils;

import com.easypan.testDao.TestUserDao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @Author: lkl
 * @Date: 2023/10/17 11:31
 * @Description:
 **/

public class testLogProxy {

    @Test
    public void test() {
        TestUserDao testDao = new TestUserDao();

        TestUserDao objectByCGLib = (TestUserDao) LogProxyByCGLib.getObjectByCGLib(testDao);
        objectByCGLib.findAllUsers();

        System.out.println("This is a 中文 statement.");
    }

}
