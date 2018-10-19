package com.openproject.visitorMessage.model;

public class VisitorMessageVO {

    private int id;
    private String userName;
    private String userId;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public boolean matchUserId(String userId){
        return userId.equals(this.userId);
    }
}

