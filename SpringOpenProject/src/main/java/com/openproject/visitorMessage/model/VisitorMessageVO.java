package com.openproject.visitorMessage.model;

public class VisitorMessageVO {

    private int visitormessage_id;
    private String userName;
    private String userId;
    private String message;

    public VisitorMessageVO(int id, String userName, String userId, String message) {
        this.visitormessage_id = visitormessage_id;
        this.userName = userName;
        this.userId = userId;
        this.message = message;
    }

    public VisitorMessageVO() {
    }

    public int getVisitormessage_id() {
        return visitormessage_id;
    }

    public void setVisitormessage_id(int visitormessage_id) {
        this.visitormessage_id = visitormessage_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "visitorMessageVO{" +
                "visitormessage_id=" + visitormessage_id +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public boolean matchUserId(String userId){
        return userId.equals(this.userId);
    }
}

