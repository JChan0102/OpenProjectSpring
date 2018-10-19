package com.openproject.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.member.model.MemberVO;
import com.openproject.member.service.MemListViewService;

@Controller
@RequestMapping(value="/member/memberList")
public class MemberListController {

@Autowired
private MemListViewService listViewService;
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView getMemberList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberListView");
		

        //memberInfo에 저장된 모든 컬럼을 가져오는 select문을 list에 저장.
        List<MemberVO> memberlist = listViewService.getmemberList();
        //el을 사용하기 위해 setAtrribute 해줌
        modelAndView.addObject("members", memberlist);
		
		return modelAndView;
		
	}
	
	
}
