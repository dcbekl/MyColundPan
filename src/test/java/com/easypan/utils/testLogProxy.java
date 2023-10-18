package com.easypan.utils;

import com.easypan.exception.BusinessException;
import com.easypan.testDao.TestUserDao;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testALL() {
        int a = 12;
        int b = 13;

        System.out.println("测试add方法");
        int sum = add(a, b);

        System.out.println("测试print方法");
        testPrint(15);
    }

    @Test
    public int add(int a, int b) {
        int c = a + b;
        System.out.println(c);
        System.out.println(c);
        System.out.println(c);
        System.out.println(c);
        return c;
    }
    private String testMsg = "Hello World";
    @Test
    public void testPrint(int n) {

        int psum  = 0;
        for(int i = 0; i <= n; ++i) {
            psum += i;
            if(i == 20) {
                throw new BusinessException("add num is 5");
            }
            System.out.println(i);
        }

        testMsg = "After edit";
        System.out.println(testMsg);
    }
}
