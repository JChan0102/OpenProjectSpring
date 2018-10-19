package com.openproject.member.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.dao.MemberDAO;
import com.openproject.member.model.MemberSessionVO;
import com.openproject.member.model.MemberVO;
import com.openproject.service.ServiceException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SignInService {
	
	@Autowired
    private MemberDAO dao;

    public String memSignIn(MemberVO member, HttpServletRequest request, HttpServletResponse response) throws ServiceException, IOException, ServletException {
        Connection conn = null;
        String url ="member/loginform";
        try {
            conn= ConnectionProvider.getConnection();

            MemberVO Dbmember = dao.select(conn,member.getUserId());
            if(Dbmember.getUserId()!=null){
             if(Dbmember.pwdEquals(member.getUserPwd())){
                 url = CookieSessionCreate(Dbmember,request,response);
             }
            }
           
            return url;
            
        } catch (SQLException e) {
            throw new ServiceException("에러 :"+e.getMessage(),e);
        } finally {
            JdbcUtil.close(conn);
        }


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
