package com.openproject.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.member.model.MemberVO;
import com.openproject.member.service.MemListViewService;
@Controller
public class MemberListJSONXMLController {

	@Autowired
	MemListViewService listViewService;
	
	@RequestMapping(value="/member/JSONXMLList")
	public String getListButton() {
		
		return "member/memberListJsonXMLView";	
		}

	@RequestMapping(value="/memberListJson")
	public ModelAndView getJSONData() {
		
		String jsonMemberList= listViewService.jsonMemberList();
		ModelAndView view= new ModelAndView();
		view.setViewName("data/memberListJson");
		view.addObject("members", jsonMemberList);
		return view;
	}
	
	@RequestMapping(value="/memberListXML")
	public ModelAndView getXMLData() {
		
		 List<MemberVO> memberlist = listViewService.getmemberList();
		
		ModelAndView view= new ModelAndView();
		view.setViewName("data/memberListXML");
		
		view.addObject("members", memberlist);
		return view;	
		}
	
}