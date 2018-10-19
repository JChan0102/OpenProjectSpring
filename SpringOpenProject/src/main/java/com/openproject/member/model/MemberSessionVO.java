package com.openproject.member.model;

public class MemberSessionVO {
    private String userId;
    private String userName;
    private String userPhoto;

    public MemberSessionVO(){}

    public MemberSessionVO(String userId, String userName, String userPhoto){
        this.userId=userId;
        this.userName=userName;
        this.userPhoto=userPhoto;


    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }
}
