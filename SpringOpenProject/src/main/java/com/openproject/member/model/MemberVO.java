package com.openproject.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhoto;
	private MultipartFile photoFile;
	private int idx;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public MemberVO() {
	}

	public MemberVO(String userId, String userPwd, String userName, String userPhoto) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPhoto = userPhoto;
	}

	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userPhoto="
				+ userPhoto + ", photoFile=" + photoFile.getOriginalFilename() + "]";
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public boolean pwdEquals(String pwd) {
		return this.userPwd.equals(pwd);
	}
}
