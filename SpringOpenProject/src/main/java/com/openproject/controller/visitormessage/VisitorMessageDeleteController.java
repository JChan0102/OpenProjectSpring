package com.openproject.controller.visitormessage;

import com.openproject.member.model.MemberSessionVO;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import com.openproject.visitorMessage.service.DeleteVisitorMessageService;
import com.openproject.visitorMessage.service.MessageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class VisitorMessageDeleteController {

    @Autowired
    private DeleteVisitorMessageService service;

    @RequestMapping(value = "/visitormessage/del", method = RequestMethod.GET)
    public String getDelete(@RequestParam("messageId") int messageid, HttpSession session, Model model) {

        VisitorMessageVO message = null;
        try {
            message = service.selectService(messageid);
        } catch (MessageNotFoundException e) {
            e.printStackTrace();
        }
        MemberSessionVO member = (MemberSessionVO) session.getAttribute("user");
        boolean equalmessage =false;
        if(message.getUserId().trim().equals(member.getUserId().trim())){
            equalmessage=true;
            model.addAttribute("messageId",messageid);
        }
        model.addAttribute("equalmessage",equalmessage);

return "visitormessage/delete";
    }
@RequestMapping(value = "/visitormessage/del/{messageId}", method = RequestMethod.GET)
    public String Delete(@PathVariable("messageId") int messageId){

        service.deleteServise(messageId);

        return "redirect:/visitormessage/list";
}
}
