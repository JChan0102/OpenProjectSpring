package com.openproject.visitorMessage.service;

import com.openproject.service.ServiceException;
import com.openproject.visitorMessage.dao.MybatisVisitorMessageDAO;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteVisitorMessageService {

    @Autowired
    private MybatisVisitorMessageDAO dao;

    public void write(VisitorMessageVO message) throws ServiceException {

        dao.insert(message);

    }

}
