package com.openproject.visitorMessage.service;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.visitorMessage.dao.VisitorMessageDAO;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.SQLException;

public class GetVisitorMessageOneViewService {

    @Autowired
    private VisitorMessageDAO dao;

    public VisitorMessageVO getMessageView(int messageId){

        Connection conn=null;
            try {
                conn= ConnectionProvider.getConnection();
               VisitorMessageVO message= dao.select(conn,messageId);

               return message;
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JdbcUtil.close(conn);
            }
            return null;
    }
}
