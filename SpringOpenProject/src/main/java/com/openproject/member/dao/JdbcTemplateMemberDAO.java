package com.openproject.member.dao;

import com.openproject.member.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class JdbcTemplateMemberDAO {

@Autowired
        private JdbcTemplate jdbcTemplate;

    ResultSet rs = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public int insert( final MemberVO member) throws SQLException {

     /*   int cnt=0;
            String sql = "insert into memberinfo values (?,?,?,?)";
           cnt=  jdbcTemplate.update(sql,member.getUserId(),member.getUserPwd(),member.getUserName(),member.getUserPhoto());
           return cnt;*/
        int resultCnt = 0;
        KeyHolder keyHolder = new GeneratedKeyHolder();
       final String insert_sql = "insert into memberinfo (userId, userpwd, username, userphoto) values(?, ?, ?, ?)";

//      resultCnt = jdbcTemplate.update(insert_sql, memberInfo.getUserID(), memberInfo.getUserPW(),
//            memberInfo.getUserName(), memberInfo.getUserPhoto());
        resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement pstmt = con.prepareStatement(insert_sql, new String[] { "idx" });
                pstmt.setString(1, member.getUserId());
                pstmt.setString(2, member.getUserPwd());
                pstmt.setString(3, member.getUserName());
                pstmt.setString(4, member.getUserPhoto());

                return pstmt;
            }
        }, keyHolder);

        Number keyValue = keyHolder.getKey();

        member.setIdx(keyValue.intValue());
        System.out.print(member.getIdx());

        return resultCnt;

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
        String sql = "update memberinfo set userpwd=?, username=?, userphoto=? where userid=?";
        jdbcTemplate.update(sql,member.getUserPwd(),member.getUserName(),member.getUserPhoto(),member.getUserId());


    }
    }