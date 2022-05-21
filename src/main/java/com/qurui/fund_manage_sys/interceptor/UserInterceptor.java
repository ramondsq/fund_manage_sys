package com.qurui.fund_manage_sys.interceptor;

import com.qurui.fund_manage_sys.util.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        System.out.println("拦截到的token："+token+" url: "+request.getRequestURL());
        if (token == null || "".equals(token)) {
            response.getWriter().write("null token Interceptor");
            return false;
        }
        if (JWTUtils.validateToken(token) == null) {
            response.getWriter().write("invalid token Interceptor");
            return false;
        }
        return true;
    }


}
