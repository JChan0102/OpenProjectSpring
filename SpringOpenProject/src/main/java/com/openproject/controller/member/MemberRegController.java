package com.openproject.controller.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	    String loca ="member/memberRegOk";
	    int cnt= 0;
		try {
		    cnt=service.signUp(member, request);
		    
		} catch (SQLException e) {
			// TODO: handle exception
			andView.addObject("msg", "에러가 발생했습니다. 다시 가입해주세요");
			loca = "view/memberRegform";
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			andView.addObject("msg", "에러가 발생했습니다. 다시 가입해주세요.");
			loca = "view/memberRegform";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
	
			e.printStackTrace();
		}
		
	    if(cnt!=1){
	    	andView.addObject("msg", "이미 가입하신 이메일입니다!");
	        loca = "view/memberRegform";

	    }else {
	    	andView.addObject("member",member);
		}

		andView.setViewName(loca);
		
		return andView;
		
	}
	
}