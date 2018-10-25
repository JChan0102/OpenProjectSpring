package com.openproject.visitorMessage.dao;


import com.openproject.jdbc.JdbcUtil;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class JdbcTemplateVisitorMessageDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static JdbcTemplateVisitorMessageDAO dao = new JdbcTemplateVisitorMessageDAO();

    public static JdbcTemplateVisitorMessageDAO getInstance() {
        return dao;
    }

    private JdbcTemplateVisitorMessageDAO() {
    }

    public int insert(VisitorMessageVO message) throws SQLException {
        int cnt = 0;
        String sql = "insert into visitorMessage (username, userid, message) values (?,?,?)";

        cnt = jdbcTemplate.update(sql, message.getUserName(), message.getUserId(), message.getMessage());


        return cnt;

    }

    public int selectListCount() throws SQLException {

        String sql ="select count(*) from visitorMessage";

        List<Integer> result= jdbcTemplate.query(sql, new RowMapper<Integer>(){
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {

                return resultSet.getInt(1);
            }
        });
       return result.isEmpty()?0:result.get(0);
    }

    private VisitorMessageVO makeMessageFromResultSet(ResultSet rs) throws SQLException {
        VisitorMessageVO message = new VisitorMessageVO();
        message.setVisitormessage_id(rs.getInt("visitormessage_id"));
        message.setUserName(rs.getString("username"));
        message.setUserId(rs.getString("userid"));
        message.setMessage(rs.getString("message"));
        return message;
    }

    public List<VisitorMessageVO> selectList(int firstRow, int endRow) throws SQLException {

        String sql = "select * from visitorMessage order by visitorMessage_id desc limit ?, ?";

        List<VisitorMessageVO> results = jdbcTemplate.query(sql, new RowMapper<VisitorMessageVO>() {
            @Override
            public VisitorMessageVO mapRow(ResultSet resultSet, int i) throws SQLException {
                return makeMessageFromResultSet(resultSet);
            }
        },firstRow,endRow);
        return results.isEmpty()?Collections.<VisitorMessageVO>emptyList():results;

    }

    public int delete( int messageId) {
       int cnt =0;
       String sql ="delete from visitormessage where visitormessage_id = ?";

       cnt = jdbcTemplate.update(sql,messageId);
       return cnt;

    }

    public VisitorMessageVO select( int messageId)  {
        String sql="select * from visitormessage where visitormessage_id=?";

        List<VisitorMessageVO> result  = jdbcTemplate.query(sql, new RowMapper<VisitorMessageVO>() {
            @Override
            public VisitorMessageVO mapRow(ResultSet resultSet, int i) throws SQLException {
                return makeMessageFromResultSet(resultSet);
            }
        },messageId);

        return result.isEmpty()?null:result.get(0);

    }

}
