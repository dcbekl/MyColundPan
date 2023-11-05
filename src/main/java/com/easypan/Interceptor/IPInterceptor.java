package com.easypan.Interceptor;



/**
 * @Description:
 * @Author: lkl
 * @Date: 2023/10/28 17:03
 **/

//package com.github.carvechris.security.bankFlow.config;

import com.easypan.component.RedisUtils;
import com.easypan.entity.config.IpConfig;
import com.easypan.utils.IPUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class IPInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求接口的ip
        // FIXME 没有获取真实的请求ip
        String ipAddress= IPUtils.getRealIP(request);

        // ip为空
        if(StringUtils.isBlank(ipAddress)) {
            return false;
        }

        // FIXME ip拦截
        // 访问ip不在白名单中
//        if(!IpConfig.ALLOW_IP_LIST.contains(ipAddress)){
//            logger.info("Blocked IP --- " + ipAddress);
//            response.getWriter().append("<h1 style=\"text-align:center;\">Not allowed!</h1>");
//            return false;
//        }

        logger.info("Release IP --- " + ipAddress);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}