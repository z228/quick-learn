package com.sjz.interceptor;

import com.sjz.annotation.UnInterception;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        System.out.println("====拦截到了方法：{}，在该方法执行之前执行===="+methodName);

        // 通过方法，可以获取该方法上的自定义注解，然后通过注解来判断该方法是否要被拦截
        // @UnInterception 是我们自定义的注解
        UnInterception unInterception = method.getAnnotation(UnInterception.class);
        if (null != unInterception) {
            return true;
        }


        // 判断用户有没有登陆，一般登陆之后的用户都有一个对应的 token
        String token = request.getHeader("token");
//        System.out.println(token);
        if (null == token || "".equals(token)) {
            System.out.println("用户未登录，没有权限执行……请登录");
            return false;
        }

        // 返回 true 才会继续执行，返回 false 则取消当前请求
        return true;

    }
}
