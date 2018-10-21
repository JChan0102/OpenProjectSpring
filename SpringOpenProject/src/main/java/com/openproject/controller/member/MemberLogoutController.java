package com.openproject.controller.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLogoutController {

	@RequestMapping(value="/member/logout")
	public String delSession(HttpServletRequest request) {
		
		request.getSession(false).invalidate();
		
		return "index";
	}
	
}
