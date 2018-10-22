package com.openproject.visitorMessage.service;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.visitorMessage.dao.JdbcTemplateVisitorMessageDAO;
import com.openproject.visitorMessage.dao.VisitorMessageDAO;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.SQLException;

public class GetVisitorMessageOneViewService {

    @Autowired
    JdbcTemplateVisitorMessageDAO dao;

    public VisitorMessageVO getMessageView(int messageId){


               VisitorMessageVO message= dao.select(messageId);

               return message;

    }
}
