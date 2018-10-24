package com.openproject.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.openproject.member.dao.JdbcTemplateMemberDAO;
import com.openproject.member.dao.MemberDAOInterface;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.dao.MemberDAO;
import com.openproject.member.model.MemberVO;
import com.openproject.service.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class MemListViewService {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    private MemberDAOInterface dao;


    public List<MemberVO> getmemberList() throws ServiceException {
        dao= sqlSessionTemplate.getMapper(MemberDAOInterface.class);
                       return dao.selectAll();
    }
    
    //memberList값을 json형태의 String으로 반환하는 메서드


    public String jsonMemberList(){
        List<MemberVO> list = getmemberList();
        String stringList = "{\"members\" : [ ";

        Iterator<MemberVO> iterator = list.iterator();

        while (iterator.hasNext()){

         MemberVO member = iterator.next();

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
