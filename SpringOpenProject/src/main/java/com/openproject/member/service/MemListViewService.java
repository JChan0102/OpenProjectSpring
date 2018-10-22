package com.openproject.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.openproject.member.dao.JdbcTemplateMemberDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.dao.MemberDAO;
import com.openproject.member.model.MemberVO;
import com.openproject.service.ServiceException;

public class MemListViewService {
    @Autowired
    private JdbcTemplateMemberDAO dao;

    public List<MemberVO> getmemberList() throws ServiceException {
                       return dao.selectAll();
    }
    
    //memberList값을 json형태의 String으로 반환하는 메서드
    public String jsonMemberList(){
        List<MemberVO> list = getmemberList();
        String stringList = "{\"members\" : [ ";

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){

         MemberVO member = (MemberVO) iterator.next();

         stringList+= "{ \"userId\" : \""+ member.getUserId()+ "\", "+
                      " \"userPwd\" : \""+ member.getUserPwd()+ "\", "+
                      " \"userName\" : \""+ member.getUserName()+ "\", "+
                      " \"userPhoto\" : \""+ member.getUserPhoto()+ "\" }";
         if(iterator.hasNext()){
             stringList +=", ";
         }
        }
        return stringList +" ] }";
    }

}
