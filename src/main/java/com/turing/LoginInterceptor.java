package com.turing;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getAttribute("username")!=null){
              log.info("拦截器放行了");
            return true;
        }else{
            log.info("拦截器拦截了");
            response.sendRedirect(request.getContextPath()+"/emp/");
            return false;
        }


    }


}
