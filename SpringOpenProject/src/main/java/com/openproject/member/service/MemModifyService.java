package com.openproject.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.dao.MemberDAO;
import com.openproject.member.model.MemberVO;
import com.openproject.service.ServiceException;

public class MemModifyService {
	
	@Autowired
    private MemberDAO dao;

	
    public MemberVO selectMember(String memberId) throws ServiceException {
        Connection conn = null;

        try {
            conn= ConnectionProvider.getConnection();
   
            return dao.select(conn,memberId);

        } catch (SQLException e) {
            throw new ServiceException("메세지등록 실패 : "+ e.getMessage(),e);
        } finally {
            JdbcUtil.close(conn);
        }
    }


    public void updateMember(MemberVO member, HttpServletRequest request) throws ServiceException, IllegalStateException, IOException {
        Connection conn = null;
        
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
        
        try {
            conn= ConnectionProvider.getConnection();
            dao.update(conn,member);
        } catch (SQLException e) {
           throw new ServiceException("메세지등록 실패 : "+ e.getMessage(),e);
        } finally {
            JdbcUtil.close(conn);
        }
    }

}
