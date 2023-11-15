package cn.edu.bistu.quickssmdemo.config;

import cn.edu.bistu.quickssmdemo.common.ResultException;
import cn.edu.bistu.quickssmdemo.entity.UserEntity;
import cn.edu.bistu.quickssmdemo.service.IUserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTWebFilter implements HandlerInterceptor {
    @Resource
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String where = request.getRequestURI();
        System.out.println(token+"token验证"+where);

        if (token.equals("")||token==null) {
            throw new ResultException("401", "身份过期，请重新登录");
        }
        String userName;
        try {
            userName = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ResultException("401", "身份信息失效，请重新登录");
        }
        UserEntity user = userService.findUserByUserName(userName);
        if (user == null) {
            throw new ResultException("401", "用户不存在，请重新登录");
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new ResultException("401", "身份信息过期，请重新登录");
        }
        if(where.contains("admin") || where.contains("addOrUpdate") ||
                where.contains("/book/delete") || where.contains("/case/delete") ||
                where.contains("/comb/delete") || where.contains("/drug/delete")){
            if(user.getRole().equals("admin")){

            }else {
                System.out.println("300");
                throw new ResultException("300","权限不足，禁止访问");
            }
        }

        return true;
    }
}
