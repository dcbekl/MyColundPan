package com.easypan.testCompoent;

import com.easypan.entity.po.UserInfo;
import com.easypan.entity.query.UserInfoQuery;
import com.easypan.mappers.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Author: lkl
 * @Date: 2023/10/17 13:32
 * @Description:
 **/

@Repository("testMysqlConnect")
public class TestMysqlConnect {

    @Resource
    private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;

    @Test
    public void testSelect() {
        try {
            UserInfo userInfo = userInfoMapper.selectByUserId("3178033358");
            System.out.println("user info" + userInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
