package com.easypan.entity.config;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lkl
 * @Date: 2023/10/28 17:35
 **/
@Component("ipConfig")
public class IpConfig {
    public static List<String> ALLOW_IP_LIST = new ArrayList<>();

    private static final String LOCAL_HOST = "127.0.0.1";

    static {
        ALLOW_IP_LIST.add(LOCAL_HOST);
        ALLOW_IP_LIST.add("111.229.171.86");
    }
}
