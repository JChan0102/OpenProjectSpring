package com.openproject.visitorMessage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.service.ServiceException;
import com.openproject.visitorMessage.dao.JdbcTemplateVisitorMessageDAO;
import com.openproject.visitorMessage.dao.VisitorMessageDAO;
import com.openproject.visitorMessage.model.VisitorMessageListView;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.springframework.beans.factory.annotation.Autowired;

public class GetVisitorMessageListService {

    @Autowired
    JdbcTemplateVisitorMessageDAO dao;

    private static GetVisitorMessageListService service = new GetVisitorMessageListService();

    public static GetVisitorMessageListService getService(){
        return service;
    }

    private GetVisitorMessageListService(){}

    private static final int MESSAGE_COUNT_PER_PAGE=5;

    public VisitorMessageListView getVisitorMessageList(int pageNumber)throws ServiceException{

        int currentPageNumber=pageNumber;
        try {
            int messageTotalCount = dao.selectListCount();
            List<VisitorMessageVO> messageVOList =null;
            int firstRow =0;
            int endRow=0;
            if(messageTotalCount>0){
                firstRow=(pageNumber-1)*MESSAGE_COUNT_PER_PAGE;
                endRow=MESSAGE_COUNT_PER_PAGE;
                messageVOList = dao.selectList(firstRow,endRow);
            }else {
                currentPageNumber=0;
                messageVOList= Collections.emptyList();
            }
            return new VisitorMessageListView(messageVOList,messageTotalCount,currentPageNumber,MESSAGE_COUNT_PER_PAGE,firstRow,endRow);
        } catch (SQLException e) {
           throw new ServiceException("메세지 목록 구하기 실패: "+ e.getMessage(),e);
        }
    }

}
