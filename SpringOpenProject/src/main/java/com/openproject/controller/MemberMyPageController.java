package com.openproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMyPageController {
	
	@RequestMapping(value="/member/mypage")
	public String getMyPage() {
		
		return "member/myPage";
		
	}

}
