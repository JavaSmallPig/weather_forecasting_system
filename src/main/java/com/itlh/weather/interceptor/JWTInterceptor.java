package com.itlh.weather.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlh.weather.util.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Java小猪
 * @Date 2024/12/3 10:04
 * JWT验证拦截器
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        //令牌建议是放在请求头中，获取请求头中令牌
        String token = request.getHeader("token");
        try {
            //验证令牌
            JWTUtils.verify(token);
            //放行请求
            return true;

        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "无效签名");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "token过期");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "token算法不一致");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "token错误");
        }
        //设置状态
        map.put("state", false);
        //将map转化成json，response使用的是Jackson
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return false;
    }
}