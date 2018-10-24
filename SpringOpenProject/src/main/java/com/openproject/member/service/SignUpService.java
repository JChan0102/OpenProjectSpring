package com.openproject.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.openproject.member.dao.MemberDAOInterface;
import com.openproject.member.dao.MybatisMemberDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.openproject.member.model.MemberVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {
/*

    @Autowired
    private MybatisMemberDAO dao;
*/
@Autowired
private SqlSessionTemplate sqlSessionTemplate;

private MemberDAOInterface dao;

    @Transactional
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

        dao=sqlSessionTemplate.getMapper(MemberDAOInterface.class);

        num = dao.insert(member);
        return num;
    }

}
