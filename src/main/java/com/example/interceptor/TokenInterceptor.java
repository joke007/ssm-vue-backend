package com.example.interceptor;

import com.example.util.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token拦截器
 * @author : Bei-Zhen
 * @date : 2020-12-26 9:27
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        System.out.println(url);

        // 登录、注册不校验token
        if(!url.endsWith("/user/userLogin") && !url.endsWith("/user/userRegister")){
            System.out.println("进入token拦截器");
            //从http请求头中取出token
            String token = request.getHeader("Authorization");
            System.out.println(token);
            //执行认证
            if(TokenUtil.verify(token)){
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}

