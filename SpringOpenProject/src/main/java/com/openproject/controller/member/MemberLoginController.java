package com.openproject.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.member.model.MemberVO;
import com.openproject.member.service.SignInService;
import com.openproject.service.ServiceException;

@Controller
@RequestMapping(value = "/member/signin")
public class MemberLoginController {
	
	@Autowired
	private SignInService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getSignInForm() {
		
		return "member/loginform";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getSignInProcess(MemberVO member,HttpServletRequest request,HttpServletResponse response) throws ServiceException, IOException, ServletException {
		
		String url = service.memSignIn(member,request,response);
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName(url);
		
		if(url.equals("member/loginform")) {
			view.addObject("msg", "아이디 혹은 비밀번호가 일치하지 않습니다.");
		}
			
		return view;
	}
}