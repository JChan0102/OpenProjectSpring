package com.openproject.visitorMessage.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.service.ServiceException;
import com.openproject.visitorMessage.dao.JdbcTemplateVisitorMessageDAO;
import com.openproject.visitorMessage.dao.VisitorMessageDAO;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteVisitorMessageService {

    @Autowired
    JdbcTemplateVisitorMessageDAO dao;

    public void write(VisitorMessageVO message) throws ServiceException {

        try {
            dao.insert(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
