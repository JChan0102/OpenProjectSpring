package com.openproject.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberFileCommand {
	 private String userId;
	    private String userPwd;
	    private String userName;
	    private MultipartFile userPhoto;
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
		public MultipartFile getUserPhoto() {
			return userPhoto;
		}
		public void setUserPhoto(MultipartFile userPhoto) {
			this.userPhoto = userPhoto;
		}
	    
	    
	    
}
