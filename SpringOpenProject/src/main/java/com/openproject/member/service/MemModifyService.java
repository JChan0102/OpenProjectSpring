package com.openproject.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.openproject.member.dao.JdbcTemplateMemberDAO;
import com.openproject.member.model.MemberSessionVO;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.dao.MemberDAO;
import com.openproject.member.model.MemberVO;
import com.openproject.service.ServiceException;

public class MemModifyService {

    @Autowired
    private JdbcTemplateMemberDAO dao;

	
    public MemberVO selectMember(String memberId) throws ServiceException {

            return dao.select(memberId);

    }


    public void updateMember(MemberVO member, HttpServletRequest request) throws ServiceException, IllegalStateException, IOException {

        String newFileName = "";

        String uploadUri="/uploadFile/userphoto";
         String dir = request.getSession().getServletContext().getRealPath(uploadUri);
    System.out.println(request.getSession().getServletContext().getRealPath(uploadUri));
         if(!member.getPhotoFile().isEmpty()) {
        	 
        	 String fileName = member.getPhotoFile().getOriginalFilename();
        	 
             newFileName = member.getUserId()+"_"+fileName;
            
             member.getPhotoFile().transferTo(new File(dir,newFileName)); 
         }else{
            newFileName= request.getParameter("preuserPhoto");
        }
         member.setUserPhoto(newFileName);
        MemberSessionVO sessionVO = (MemberSessionVO) request.getSession().getAttribute("user");

        if(sessionVO.getUserId().equals(member.getUserId())){
            request.getSession().setAttribute("user",new MemberSessionVO(member.getUserId(),member.getUserName(),member.getUserPhoto()));
        }


            dao.update(member);

    }

}
