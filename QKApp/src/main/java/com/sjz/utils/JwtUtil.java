package com.sjz.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    //有效期
    public static final Long JWT_TTL=60*60*1000L;//一个小时
    //设置密钥明文
    public static final String JWT_KEY="sjz";

    public static String getUUID(){
        String token= UUID.randomUUID().toString().replaceAll("-","");
        return token;
    }

    /**
     * 生成jwt
     * @param subject token中要存放的数据（json格式）
     * @return
     */
    public static String createJWT(String subject){
        JwtBuilder builder=getJwtBuilder(subject,null,getUUID());//设置过期时间
        return builder.compact();
    }

    /**
     * 生成jwt
     * @param subject   token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return
     */
    public static String createJWT(String subject,Long ttlMillis){
        JwtBuilder builder=getJwtBuilder(subject,ttlMillis,getUUID());
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String subject,Long ttlMillis,String uuid){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey=generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis==null){
            ttlMillis=JwtUtil.JWT_TTL;
        }
        long expMillis=nowMillis+ ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)            //唯一的id
                .setSubject(subject)    //主题 可以是json数据
                .setIssuer("sjz")        //签发者
                .setIssuedAt(now)       //签发时间
                .signWith(signatureAlgorithm,secretKey) //使用HS256对称加密算法签名，第二个参数为密钥
                .setExpiration(expDate);
    }

    /**
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id,String subject,Long ttlMillis){
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);//设置过期时间
        return builder.compact();
    }

    /**
     * 生成加密后的密钥 secretKey
     * @return
     */
    public static  SecretKey generalKey(){
        byte[] encodeKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKeySpec key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }

    /**
     * 解析
     * @param jwt
     * @return
     */
    public static Claims pareseJWT(String jwt){
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) {
        //jwt加密
        String jwt = createJWT("123456");
        System.out.println(jwt);

        //jwt解密
        Claims claims = pareseJWT(jwt);
        String subject = claims.getSubject();
        System.out.println(subject);
    }
}
