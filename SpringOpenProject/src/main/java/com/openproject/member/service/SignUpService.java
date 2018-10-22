package com.openproject.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.openproject.member.dao.JdbcTemplateMemberDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.jdbc.ConnectionProvider;
import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.dao.MemberDAO;
import com.openproject.member.model.MemberVO;
import com.openproject.service.ServiceException;

public class SignUpService {
/*

	@Autowired
    private MemberDAO dao;
*/

    @Autowired
    private JdbcTemplateMemberDAO dao;

    public int signUp(MemberVO member, HttpServletRequest request) throws SQLException, IllegalStateException, IOException {
        int num = 0;
        String newFileName = "";

        String uploadUri = "/uploadFile/userphoto";
        String dir = request.getSession().getServletContext().getRealPath(uploadUri);

        if (!member.getPhotoFile().isEmpty()) {

            String fileName = member.getPhotoFile().getOriginalFilename();

            newFileName = member.getUserId() + "_" + fileName;

            member.getPhotoFile().transferTo(new File(dir, newFileName));
        }
        member.setUserPhoto(newFileName);


        num = dao.insert(member);
        return num;
    }

}
