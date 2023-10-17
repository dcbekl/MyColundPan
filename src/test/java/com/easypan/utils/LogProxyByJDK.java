package com.easypan.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;

/**
 * @Author: lkl
 * @Date: 2023/10/17 11:28
 * @Description:
 **/

public class LogProxyByJDK {
    /**
     * 生成对象的代理对象，对被代理对象进行所有方法日志增强
     * 参数：原始对象
     * 返回值：被代理的对象
     * JDK 动态代理
     *  基于接口的动态代理
     *  被代理类必须实现接口
     *  JDK提供的
     */
    public static Object getObject(final Object obj){
        /**
         * 创建对象的代理对象
         * 参数一：类加载器
         * 参数二：对象的接口
         * 参数三：调用处理器，代理对象中的方法被调用，都会在执行方法。对所有被代理对象的方法进行拦截
         */
        Object proxyInstance = Proxy.newProxyInstance(obj.getClass().getClassLoader()
                , obj.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //方法执行前
                        long startTime = System.currentTimeMillis();

                        Object result = method.invoke(obj, args);//执行方法的调用

                        //方法执行后
                        long endTime = System.currentTimeMillis();
                        SimpleDateFormat sdf = new SimpleDateFormat();
                        System.out.printf(String.format("%s方法执行结束时间：%%s ；方法执行耗时：%%d%%n"
                                , method.getName()), sdf.format(endTime), endTime - startTime);
                        return result;
                    }
                });
        return proxyInstance;
    }
}