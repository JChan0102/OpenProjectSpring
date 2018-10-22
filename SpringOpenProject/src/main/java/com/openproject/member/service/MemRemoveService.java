package com.openproject.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.openproject.member.dao.JdbcTemplateMemberDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.dao.MemberDAO;
import com.openproject.service.ServiceException;

public class MemRemoveService {

    @Autowired
    private JdbcTemplateMemberDAO dao;

    public void removeMember(String userId) throws ServiceException {
        Connection conn =null;
        try {
            conn= ConnectionProvider.getConnection();
      
            dao.delete(userId);
        } catch (SQLException e) {
            JdbcUtil.rollback(conn);
            throw new ServiceException("메세지등록 실패 : "+ e.getMessage(),e);
        } finally {
            JdbcUtil.close(conn);
        }


    }

}
