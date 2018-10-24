package com.openproject.member.dao;

import com.openproject.member.model.MemberVO;

import java.util.List;

public interface MemberDAOInterface {
    MemberVO select(String userId);
    int insert(MemberVO member);
    List<MemberVO> selectAll();
    void delete(String userId);
    void update(MemberVO member);
}
