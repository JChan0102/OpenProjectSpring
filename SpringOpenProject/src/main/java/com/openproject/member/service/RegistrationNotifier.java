package com.openproject.member.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RegistrationNotifier {

@Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String memberemail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("[Simple] 회원 가입 안내");
        message.setFrom("jchan010222@gmail.com");
        message.setText("회원 가입을 환영합니다.");
        message.setTo(memberemail);
        try {
            javaMailSender.send(message);
        } catch (MailException ex) {
            ex.printStackTrace();
        }

    }

    public void mailSendHtml(String email){

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            message.setSubject("[안내] 회원가입을 축하합니다","UTF-8");
            String htmlStr= "<b> Hello</b> 회원님<br>" +
                    "회원가입 감사합니다 <br>" +
                    "<a href=\"http://www.naver.com\"> 사이트가기</a>";

            message.setText(htmlStr, "utf-8", "html");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }



}
