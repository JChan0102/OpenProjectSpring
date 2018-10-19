package com.openproject.visitorMessage.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.service.ServiceException;
import com.openproject.visitorMessage.dao.VisitorMessageDAO;
import com.openproject.visitorMessage.model.VisitorMessageVO;

public class WriteVisitorMessageService {
    private static WriteVisitorMessageService service = new WriteVisitorMessageService();
    public static WriteVisitorMessageService getService (){
        return service;
    }
    private WriteVisitorMessageService(){};

    public void write(VisitorMessageVO message) throws ServiceException {
        Connection conn = null;
        try {
            conn= ConnectionProvider.getConnection();
            VisitorMessageDAO dao = VisitorMessageDAO.getInstance();
            dao.insert(conn,message);
        } catch (SQLException e) {
          throw  new ServiceException("메세지 등록 실패 :"+ e.getMessage(), e) ;
        }finally {
            JdbcUtil.close(conn);
        }


    }

}
