package com.easypan.component;

import com.easypan.entity.constants.Constants;
import com.easypan.entity.dto.SysSettingsDto;
import com.easypan.entity.dto.UserSpaceDto;
import com.easypan.entity.po.UserInfo;
import com.easypan.entity.query.UserInfoQuery;
import com.easypan.mappers.UserInfoMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("redisComponent")
public class RedisComponent {

    @Resource
    private RedisUtils redisUtils; // redis 中存放的value类型

    @Resource
    private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;


    /**
     * 获取系统设置
     *
     * @return
     */
    public SysSettingsDto getSysSettingsDto() {
        // 从redis中获取key为easypan:syssetting:的值
        SysSettingsDto sysSettingsDto = (SysSettingsDto) redisUtils.get(Constants.REDIS_KEY_SYS_SETTING);

        // 如果不存在，则创建并存入redis
        if (sysSettingsDto == null) {
            sysSettingsDto = new SysSettingsDto();
            redisUtils.setex(Constants.REDIS_KEY_SYS_SETTING, sysSettingsDto, 60 * 60);
        }

        return sysSettingsDto;
    }

    /**
     * 获取用户使用的空间
     *
     * @param userId
     * @return
     */
    public UserSpaceDto getUserSpaceUse(String userId) {
        UserSpaceDto spaceDto = (UserSpaceDto) redisUtils.get(Constants.REDIS_KEY_USER_SPACE_USE + userId);
        if (null == spaceDto) {
            spaceDto = new UserSpaceDto();
            // TODO 查询用户已经上传文件的总和
//            Long useSpace = this.fileInfoMapper.selectUseSpace(userId);
            spaceDto.setUseSpace(0L);
            spaceDto.setTotalSpace(getSysSettingsDto().getUserInitUseSpace() * Constants.MB);
            redisUtils.setex(Constants.REDIS_KEY_USER_SPACE_USE + userId, spaceDto, Constants.REDIS_KEY_EXPIRES_DAY);
        }
        return spaceDto;
    }

    /**
     * 保存已使用的空间
     *
     * @param userId
     */
    public void saveUserSpaceUse(String userId, UserSpaceDto userSpaceDto) {
        redisUtils.setex(Constants.REDIS_KEY_USER_SPACE_USE + userId, userSpaceDto, Constants.REDIS_KEY_EXPIRES_DAY);
    }

//    public UserSpaceDto resetUserSpaceUse(String userId) {
//        UserSpaceDto spaceDto = new UserSpaceDto();
//        Long useSpace = this.fileInfoMapper.selectUseSpace(userId);
//        spaceDto.setUseSpace(useSpace);
//
//        UserInfo userInfo = this.userInfoMapper.selectByUserId(userId);
//        spaceDto.setTotalSpace(userInfo.getTotalSpace());
//        redisUtils.setex(Constants.REDIS_KEY_USER_SPACE_USE + userId, spaceDto, Constants.REDIS_KEY_EXPIRES_DAY);
//        return spaceDto;
//    }

}