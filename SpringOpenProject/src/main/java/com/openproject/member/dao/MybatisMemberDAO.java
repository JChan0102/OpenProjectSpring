package com.openproject.member.dao;

import com.openproject.member.model.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
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
public class MybatisMemberDAO {

@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private String mapperPath = "com.openproject.mapper.mybatis.MemberMapper";

    public int insert( final MemberVO member) throws SQLException {

        return sqlSessionTemplate.update(mapperPath+".insertMember",member);
    }


    public MemberVO select(String userId) {

        return sqlSessionTemplate.selectOne(mapperPath+".selectById",userId);
    }
/*

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


    }*/
    }