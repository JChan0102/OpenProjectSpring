package com.openproject.interceptor;

import com.openproject.member.model.MemberSessionVO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {


        HttpSession session = request.getSession(false);

        if(session!=null){
            Object obj=  session.getAttribute("user");
            if(obj !=null){
                return true;
            }

        }

        response.sendRedirect(request.getContextPath()+"/member/signin");

        return false;
    }


}
