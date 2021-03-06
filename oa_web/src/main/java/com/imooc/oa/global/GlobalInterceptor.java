package com.imooc.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GlobalInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURL().toString();
        if (url.toLowerCase().indexOf("login") >= 0) {
            return true;
        }

            if (httpServletRequest.getSession().getAttribute("employee") != null) {
                return true;
            }


            httpServletResponse.sendRedirect("/to_login");
            return false;
        }

        public void postHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
        o, ModelAndView modelAndView) throws Exception {

        }

        public void afterCompletion (HttpServletRequest httpServletRequest, HttpServletResponse
        httpServletResponse, Object o, Exception e) throws Exception {

        }
    }

