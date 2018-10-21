package com.openproject.member.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.openproject.jdbc.JdbcUtil;
import com.openproject.member.model.MemberVO;

public class MemberDAO {



    ResultSet rs = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public int insert(Connection conn, MemberVO member) throws SQLException {
        int cnt=0;
        try {
            String sql = "insert into memberinfo values (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserPwd());
            pstmt.setString(3, member.getUserName());
            pstmt.setString(4, member.getUserPhoto());
           cnt= pstmt.executeUpdate();
           return cnt;
        }finally {
            JdbcUtil.close(pstmt);
        }


    }


    public MemberVO select(Connection conn, String userId) {
        try {

            String sql = "select * from memberinfo where userid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

        if (rs.next()) {
            return new MemberVO(rs.getString("userid"), rs.getString("userpwd"), rs.getString("username"), rs.getString("userphoto"));
        }

    } catch (SQLException g) {
        System.out.println("DB연결 실패");
        g.printStackTrace();
    } finally {
        JdbcUtil.close(rs);
        JdbcUtil.close(pstmt);
    }
        return new MemberVO(null, null, null, null);
    }

    public List<MemberVO> selectAll(Connection conn) {
        List<MemberVO> members = new ArrayList<MemberVO>();

        try {
            String sql = "select * from memberinfo";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                members.add(new MemberVO(rs.getString("userid"), rs.getString("userpwd"), rs.getString("username"), rs.getString("userphoto")));
            }

        } catch (SQLException g) {
            System.out.println("DB연결 실패");
            g.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
      }
        return members;
    }

    public void delete(Connection conn, String UserID) {
        try {
            String sql = "delete from memberinfo where userid=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, UserID);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt);
        }
    }

    public void update(Connection conn, MemberVO member) {
        try {

            String sql = "update memberinfo set userpwd=?, username=?, userphoto=? where userid=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, member.getUserPwd());
            pstmt.setString(2, member.getUserName());
            pstmt.setString(3, member.getUserPhoto());
            pstmt.setString(4, member.getUserId());


            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt);
        }

    }
}
