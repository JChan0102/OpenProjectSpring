package com.openproject.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openproject.member.service.MemRemoveService;

@Controller
@RequestMapping(value="/member/remove")
public class MemberRemoveController {

	@Autowired
	MemRemoveService service;
	@RequestMapping(method=RequestMethod.GET)
	public String memberRemove(@RequestParam("removeid") String userId) {
		
		service.removeMember(userId);
		
		return "redirect:/member/memberList";
	}
	
	
}
