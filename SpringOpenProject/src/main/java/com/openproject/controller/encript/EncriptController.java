package com.openproject.controller.encript;


import com.openproject.encript.AES256Util;
import com.openproject.encript.Sha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@Controller
@RequestMapping("/encript")
public class EncriptController {

    @Autowired
    private Sha256 sha256;

    @Autowired
    private AES256Util aes256Util;

    @RequestMapping(method = RequestMethod.GET)
    public String form () {

        return "form";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String result(@RequestParam("id") String id, @RequestParam("pwd") String pwd, Model model){

        String eId= sha256.encrypt(id);

        String ePwd = sha256.encrypt(pwd);

        String aId = "";
        String aPwd="";
        try {
            aId= aes256Util.encrypt(id);
            aPwd =aes256Util.encrypt(pwd);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        model.addAttribute("aid",aId);
        model.addAttribute("apwd",aPwd);

        try {
            System.out.println(aes256Util.decrypt(aId));
            System.out.println(aes256Util.decrypt(aPwd));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        model.addAttribute("id",eId);
        model.addAttribute("pwd",ePwd);

        return "result";
    }
}
