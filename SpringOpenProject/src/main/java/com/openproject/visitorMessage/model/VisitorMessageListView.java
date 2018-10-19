package com.openproject.visitorMessage.model;

import java.util.List;

public class VisitorMessageListView {
    private int messageTotalCount;
    private int currentPageNumber;
    private List<VisitorMessageVO> messageList;
    private int pageTotalCount;
    private int messageCountPerPage;
    private int firstRow;
    private int endRow;

    public VisitorMessageListView(List<VisitorMessageVO> messageList, int messageTotalCount, int currentPageNumber, int messageCountPerPage, int firstRow, int endRow){

        this.messageList=messageList;
        this.messageTotalCount = messageTotalCount;
        this.currentPageNumber = currentPageNumber;
        this.messageCountPerPage = messageCountPerPage;
        this.firstRow = firstRow;
        this.endRow = endRow;
        calculatePageTotalCount();

    }

    private void calculatePageTotalCount() {
        if(messageTotalCount==0){
            pageTotalCount=0;
        }else{
            pageTotalCount=messageTotalCount/messageCountPerPage;
            if(messageTotalCount%messageCountPerPage>0){
                pageTotalCount++;
            }
        }


    }

    public int getMessageTotalCount() {
        return messageTotalCount;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public List<VisitorMessageVO> getMessageList() {
        return messageList;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public int getMessageCountPerPage() {
        return messageCountPerPage;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public boolean isEmpty(){
        return messageTotalCount==0;
    }
}
