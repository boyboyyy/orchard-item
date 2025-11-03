package com.orchard.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;



public  class JwtUtil {
    /**
     * 生成jwt
     * 使用Hs256算法, 私匙使用固定秘钥
     *
     * @param secretKey jwt秘钥
     * @param ttlMillis jwt过期时间(毫秒)
     * @param claims    设置的信息
     * @return
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String,Object>claims){

        //指定签名的时候使用的签名算法，header部分
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT时间
        long expMillis =  System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);
        //设计jwt的body
        JwtBuilder builder = Jwts.builder()
                //设置一个自己创建的声明，会覆盖原有的声明
                .setClaims(claims)
                //设置签名算法和签名使用的密钥
                .signWith(signatureAlgorithm,secretKey.getBytes(StandardCharsets.UTF_8))
                //设置过期时间
                .setExpiration(exp);

        return builder.compact();


    }
    /**
     * Token解密
     *
     * @param secretKey jwt秘钥 此秘钥一定要保留好在服务端, 不能暴露出去, 否则sign就可以被伪造, 如果对接多个客户端建议改造成多个
     * @param token     加密后的token
     * @return
     */
    public static Claims parseJWT(String secretKey, String token) {
        // 得到DefaultJwtParser
        Claims claims = Jwts.parser()
                // 设置签名的秘钥
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                // 设置需要解析的jwt
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
