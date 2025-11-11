package com.orchard.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.orchard.constant.JwtClaimsConstant;
import com.orchard.properties.JwtProperties;
import com.orchard.utils.JwtUtil;
import com.orchard.context.BaseContext;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static com.orchard.utils.JwtUtil.parseJWT;

/**
 * jwt令牌校验的拦截器
 */
@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 校验jwt
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        //1、从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getAdminTokenName());
        if (token == null) {
            // 从 cookie 中取 token
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    if (jwtProperties.getAdminTokenName().equals(cookie.getName())) {
                        // 你的 TOKEN 存的是一个 JSON，要先解析
                        // 解码 Cookie 的值
                        String cookieValue = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8.name());
                        JSONObject jsonObject = JSONObject.parseObject(cookieValue);
                        token = jsonObject.getString("token");
                        break;
                    }
                }
            }
        }
        //2、校验令牌
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
//          long.valueOf作用是将字符串形式的数字（如 "123"）转换为 Long 类型。
            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
            log.info("当前员工id：", empId);
            //将id存入ThreadLocal
            BaseContext.setCurrentId(empId);
            //3、通过，放行
            return true;
        } catch (Exception ex) {
            //4、不通过，响应401状态码
            response.setStatus(401);
            return false;
        }
    }
}
