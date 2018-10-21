package com.openproject.controller.visitormessage;

import com.openproject.visitorMessage.model.VisitorMessageVO;
import com.openproject.visitorMessage.service.WriteVisitorMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VisitorMessageWriteController {

    @Autowired
    private WriteVisitorMessageService service;

    @RequestMapping(value="/visitormessage/write", method = RequestMethod.GET)
    public String getForm() {

        return "visitormessage/write";
    }
@RequestMapping(value = "/visitormessage/write", method = RequestMethod.POST)
    public String insert(VisitorMessageVO message){

        service.write(message);

        return "redirect:/visitormessage/list";
    }

}
