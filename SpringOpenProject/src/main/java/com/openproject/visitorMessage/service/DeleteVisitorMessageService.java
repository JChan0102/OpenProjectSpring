package com.openproject.visitorMessage.service;


import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.service.ServiceException;
import com.openproject.visitorMessage.dao.VisitorMessageDAO;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteVisitorMessageService {

    @Autowired
    VisitorMessageDAO dao;

    public VisitorMessageVO selectService(int messageId) throws MessageNotFoundException {
        Connection conn = null;

        try {
            conn=ConnectionProvider.getConnection();
            VisitorMessageVO message = dao.select(conn,messageId);
            if (message == null) {
                throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
            }
            return message;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn);
        }
            return null;
    }



    public void deleteServise(int messageId)  {

        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false);
            dao.delete(conn, messageId);
            conn.commit();
        } catch (SQLException ex) {
            JdbcUtil.rollback(conn);
            throw new ServiceException("삭제 처리 중 에러가 발생했습니다:" + ex.getMessage(), ex);
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(false);
                } catch (SQLException e) {
                }
                JdbcUtil.close(conn);
            }
        }


    }



}
