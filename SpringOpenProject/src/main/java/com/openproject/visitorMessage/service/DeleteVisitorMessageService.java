package com.openproject.visitorMessage.service;

import com.openproject.visitorMessage.dao.JdbcTemplateVisitorMessageDAO;
import com.openproject.visitorMessage.dao.MybatisVisitorMessageDAO;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteVisitorMessageService {

/*    @Autowired
    VisitorMessageDAO dao;*/
/*
@Autowired
    JdbcTemplateVisitorMessageDAO dao;*/
@Autowired
 private MybatisVisitorMessageDAO dao;

    public VisitorMessageVO selectService(int messageId) throws MessageNotFoundException {

            VisitorMessageVO message = dao.select(messageId);
            if (message == null) {
                throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
            }
            return message;
    }


    public void deleteServise(int messageId)  {
            dao.delete(messageId);
        }

    }

