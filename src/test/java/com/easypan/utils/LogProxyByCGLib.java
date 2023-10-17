package com.easypan.utils;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

/**
 * @Author: lkl
 * @Date: 2023/10/17 11:30
 * @Description:
 **/

public class LogProxyByCGLib {

    /**
     * 使用CGLib创建动态代理对象
     * 第三方提供的的创建代理对象的方式CGLib
     * 被代理对象不能用final修饰
     * 使用的是Enhancer类创建代理对象
     */
    public static Object getObjectByCGLib(final Object obj){
        /**
         * 使用CGLib的Enhancer创建代理对象
         * 参数一：对象的字节码文件
         * 参数二：方法的拦截器
         */
        Object proxyObj = Enhancer.create(obj.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //方法执行前
                long startTime = System.currentTimeMillis();

                Object invokeObject = method.invoke(obj, objects);//执行方法的调用

                //方法执行后
                long endTime = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat();
                System.out.printf(String.format("%s方法执行结束时间：%%s ；方法执行耗时：%%d%%n"
                        , method.getName()), sdf.format(endTime), endTime - startTime);
                return invokeObject;
            }
        });


        return proxyObj;
    }
}
