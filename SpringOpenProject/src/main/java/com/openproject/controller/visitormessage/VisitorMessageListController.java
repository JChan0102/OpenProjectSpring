package com.openproject.controller.visitormessage;

import com.openproject.service.ServiceException;
import com.openproject.visitorMessage.model.VisitorMessageListView;
import com.openproject.visitorMessage.service.GetVisitorMessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VisitorMessageListController {

    @Autowired
    private GetVisitorMessageListService service;

    @RequestMapping(value="/visitormessage/list", method= RequestMethod.GET)
    public ModelAndView getList(@RequestParam(value="page", defaultValue="1") int pageNumber) throws ServiceException {

        ModelAndView view= new ModelAndView();
        view.setViewName("visitormessage/list");

        VisitorMessageListView viewData =service.getVisitorMessageList(pageNumber);

        view.addObject("viewData", viewData);
        return view;

    }


}
