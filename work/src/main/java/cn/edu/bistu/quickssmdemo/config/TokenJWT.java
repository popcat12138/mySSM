package cn.edu.bistu.quickssmdemo.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenJWT {
    public static String genToken(String userName,String password){
        return JWT.create().withAudience(userName)
                // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + (5 * 60 * 60 * 1000)))
                // 5小时后token过期
                .sign(Algorithm.HMAC256(password));
                // 以 password 作为 token 的密钥
    }
}
