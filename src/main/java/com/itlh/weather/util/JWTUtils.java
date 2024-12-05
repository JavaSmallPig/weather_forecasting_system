package com.itlh.weather.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @Author Java小猪
 * @Date 2024/12/3 10:02
 */
public class JWTUtils {
    private static final String SIGNATURE = "simple";

    /**
     * 生成token
     *
     * @param map //传入payload
     * @return 返回token
     */
    public static String getToken(Map<String, String> map) {
        // 设置token过期时间为10分钟
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, 10);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGNATURE));
        return token;
    }

    /**
     * 验证token
     *
     * @param token
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

    /**
     * 获取token信息的方法
     *
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token) {
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}

