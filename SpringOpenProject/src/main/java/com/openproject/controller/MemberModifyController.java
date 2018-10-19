package com.openproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.member.model.MemberSessionVO;
import com.openproject.member.model.MemberVO;
import com.openproject.member.service.MemModifyService;
import com.openproject.service.ServiceException;

@Controller
@RequestMapping("/member/modify")
public class MemberModifyController {
	@Autowired
	MemModifyService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getForm(@RequestParam("modiid") String userId) {
		
		
		MemberVO member = service.selectMember(userId);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("member/memberModiForm");
		
		view.addObject("member", member);
		
		return view;
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public String memberUpdate(MemberVO member, HttpServletRequest request, HttpSession session) throws ServiceException {
	
        
        try {
			service.updateMember(member,request);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return "redirect:/member/memberList";
	
		}
        
        session.setAttribute("user", new MemberSessionVO(member.getUserId(), member.getUserName(), member.getUserPhoto()));
        
       return "redirect:/member/memberList";
		
	}
	
	
	
}
