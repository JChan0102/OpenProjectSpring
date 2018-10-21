package com.openproject.controller.visitormessage;

import com.openproject.visitorMessage.model.VisitorMessageVO;
import com.openproject.visitorMessage.service.GetVisitorMessageOneViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VisitorMessageOneViewController {
    @Autowired
    private GetVisitorMessageOneViewService service;

    @RequestMapping(value = "/visitormessage/view/{id}")
    public ModelAndView getView(@PathVariable("id") int id){

        VisitorMessageVO messageVO = service.getMessageView(id);

        ModelAndView view = new ModelAndView();

        view.setViewName("visitormessage/view");
        view.addObject("message",messageVO);

        return view;
    }

}
