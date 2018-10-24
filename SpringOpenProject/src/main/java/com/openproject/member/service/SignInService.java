package com.openproject.member.service;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openproject.member.dao.MemberDAOInterface;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.member.model.MemberSessionVO;
import com.openproject.member.model.MemberVO;
import com.openproject.service.ServiceException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;
@Service
public class SignInService {

    /*

       @Autowired
       private MybatisMemberDAO dao;
   */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    private MemberDAOInterface dao;

    public String memSignIn(MemberVO member, HttpServletRequest request, HttpServletResponse response) throws ServiceException, IOException, ServletException { Connection conn = null;
        String url ="member/loginform";

        dao= sqlSessionTemplate.getMapper(MemberDAOInterface.class);
            MemberVO Dbmember = dao.select(member.getUserId());
            if(Dbmember.getUserId()!=null){
             if(Dbmember.pwdEquals(member.getUserPwd())){
                 url = CookieSessionCreate(Dbmember,request,response);
             }
            }
            return url;
    }

    private String CookieSessionCreate(MemberVO member, HttpServletRequest request, HttpServletResponse response){
        String ck = request.getParameter("idck");
        Cookie cookie = new Cookie("preId",member.getUserId());
        if(ck!=null){
            response.addCookie(cookie);
        }else {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        request.getSession(false).setAttribute("user", new MemberSessionVO(member.getUserId(),member.getUserName(),member.getUserPhoto()));
        return "member/myPage";
    }

}
