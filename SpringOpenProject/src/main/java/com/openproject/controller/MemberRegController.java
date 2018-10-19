package com.openproject.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.member.model.MemberVO;
import com.openproject.member.service.SignUpService;

@Controller
@RequestMapping(value = "/member/signup")
public class MemberRegController {
@Autowired
private SignUpService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getSignUpForm() {
		ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("member/memberRegform");
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView memberReg(MemberVO member, HttpServletRequest request)  {

		ModelAndView andView= new ModelAndView();
	    String loca ="member/loginform";
	    int cnt= 0;
		try {
		    cnt=service.signUp(member, request);
		    
		} catch (SQLException e) {
			// TODO: handle exception
			loca="member/fail";
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			loca="member/fail";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
		}
		
	    if(cnt!=1){
	    	andView.addObject("msg", "이미 가입하신 이메일입니다!");
	        loca = "view/memberRegform";

	    }

		andView.setViewName(loca);
		
		return andView;
		
	}
	
}