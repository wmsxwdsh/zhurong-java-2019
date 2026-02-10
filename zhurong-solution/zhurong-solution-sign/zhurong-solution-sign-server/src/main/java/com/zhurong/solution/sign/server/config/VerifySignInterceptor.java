package com.zhurong.solution.sign.server.config;

import com.zhurong.solution.sign.server.annotation.VerifySign;
import com.zhurong.utils.response.InfoCoinResponse;
import com.zhurong.utils.response.ResponseEnum;
import com.zhurong.utils.sign.SignValidateUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 验签拦截器
 * 2019/3/4
 */
public class VerifySignInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        if (!verifySignMethod(handler, request)) {
            response.sendRedirect(request.getContextPath() + "/signError");
            return false;
        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
        @Nullable Exception ex) throws Exception {

    }

    private boolean verifySignMethod(Object handler, HttpServletRequest request) {

        System.out.println("这里进行md5验签或者rsa验签------------");

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //获取方法上的注解
            VerifySign verifySign = handlerMethod.getMethod().getAnnotation(VerifySign.class);
            //如果方法上的注解为空 则获取类的注解
            if (verifySign == null) {
                verifySign = handlerMethod.getMethod().getDeclaringClass().getAnnotation(VerifySign.class);
            }
            if (verifySign != null) {
                InfoCoinResponse infoCoinResponse = SignValidateUtil.md5Verify(request);
                if (infoCoinResponse.getStatusCode().equals(ResponseEnum.success.getCode())) {
                    return true;
                }
                return false;
            }
        }

        return true;
    }

}