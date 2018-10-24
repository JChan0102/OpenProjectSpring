package com.openproject.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.openproject.member.dao.JdbcTemplateMemberDAO;
import com.openproject.member.dao.MemberDAOInterface;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.dao.MemberDAO;
import com.openproject.service.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class MemRemoveService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    private MemberDAOInterface dao;

    public void removeMember(String userId) throws ServiceException {
        dao= sqlSessionTemplate.getMapper(MemberDAOInterface.class);

            dao.delete(userId);

    }

}
