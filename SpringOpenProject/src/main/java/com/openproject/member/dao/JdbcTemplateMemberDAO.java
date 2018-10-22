package com.openproject.member.dao;

import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplateMemberDAO {

@Autowired
        private JdbcTemplate jdbcTemplate;

    ResultSet rs = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public int insert( MemberVO member) throws SQLException {

        int cnt=0;
            String sql = "insert into memberinfo values (?,?,?,?)";
           cnt=  jdbcTemplate.update(sql,member.getUserId(),member.getUserPwd(),member.getUserName(),member.getUserPhoto());
           return cnt;
    }


    public MemberVO select(String userId) {
        List<MemberVO> result = jdbcTemplate.query("select * from memberinfo where userid=?",
                new RowMapper<MemberVO>() {
                    @Override
                    public MemberVO mapRow(ResultSet resultSet, int i) throws SQLException {
                        MemberVO member = new MemberVO(resultSet.getString("userid"),
                                resultSet.getString("userpwd"),
                                resultSet.getString("username"),
                                resultSet.getString("userphoto"));
                        return member;
                    }
                }, userId);
        return result.isEmpty() ? null : result.get(0);
    }


    public List<MemberVO> selectAll() {

        String sql = "select * from memberinfo";
        List<MemberVO> results= jdbcTemplate.query(sql, new RowMapper<MemberVO>() {
            @Override
            public MemberVO mapRow(ResultSet resultSet, int i) throws SQLException {
                MemberVO member = new MemberVO(resultSet.getString("userid"),
                        resultSet.getString("userpwd"),
                        resultSet.getString("username"),
                        resultSet.getString("userphoto"));
                return member;
            }
        });
        return results;
    }

    public void delete( String UserID) {
        String sql = "delete from memberinfo where userid=?";

        jdbcTemplate.update(sql,UserID);
    }

    public void update( MemberVO member) {
        String sql = "update memberifo set userpwd=?, username=?, userphoto=? where userud=?";
        jdbcTemplate.update(sql,member.getUserPwd(),member.getUserName(),member.getUserPhoto(),member.getUserId());


    }
}
