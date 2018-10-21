package com.openproject.visitorMessage.dao;


import com.openproject.jdbc.JdbcUtil;
import com.openproject.visitorMessage.model.VisitorMessageVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisitorMessageDAO {

    private static VisitorMessageDAO dao = new VisitorMessageDAO();
    public static VisitorMessageDAO getInstance() {
        return dao;
    }
    private VisitorMessageDAO(){}
    public int insert (Connection conn, VisitorMessageVO message) throws SQLException {
        PreparedStatement pstmt = null;
       try{

           pstmt= conn.prepareStatement("insert into visitorMessage (username, userid, message) values (?,?,?)");
           pstmt.setString(1,message.getUserName());
           pstmt.setString(2,message.getUserId());
           pstmt.setString(3,message.getMessage());

           return pstmt.executeUpdate();

    } finally {
           JdbcUtil.close(pstmt);
       }
    }
    public int selectListCount (Connection conn)throws SQLException{
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from visitorMessage";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }



    }
    private VisitorMessageVO makeMessageFromResultSet(ResultSet rs) throws SQLException {
        VisitorMessageVO message = new VisitorMessageVO();
        message.setId(rs.getInt("visitormessage_id"));
        message.setUserName(rs.getString("username"));
        message.setUserId(rs.getString("userid"));
        message.setMessage(rs.getString("message"));
        return message;
    }

    public List<VisitorMessageVO> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
        	
            String sql = "select * from visitorMessage order by visitorMessage_id desc limit ?, ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,firstRow);
            pstmt.setInt(2,endRow);
         rs= pstmt.executeQuery();
        if(rs.next()){
            List<VisitorMessageVO> messageVOList = new ArrayList<VisitorMessageVO>();
            do{
                messageVOList.add(makeMessageFromResultSet(rs));
            }while (rs.next());
                return messageVOList;
            }else{
                return Collections.emptyList();
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }

    }

    public int delete(Connection conn, int messageId) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("delete from visitormessage where visitormessage_id = ?");
            pstmt.setInt(1, messageId);
            return pstmt.executeUpdate();
        } finally {
            JdbcUtil.close(pstmt);
        }
    }
    public VisitorMessageVO select(Connection conn, int messageId) throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            pstmt=conn.prepareStatement("select * from visitormessage where visitormessage_id=?");
            pstmt.setInt(1,messageId);
            rs=pstmt.executeQuery();
            if(rs.next()){
               return new VisitorMessageVO(rs.getInt("visitormessage_id"),rs.getString("username"),rs.getString("userid"),rs.getString("message"));
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
        return null;

    }

}
