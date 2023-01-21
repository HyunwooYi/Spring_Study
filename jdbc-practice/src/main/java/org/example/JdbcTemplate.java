package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
    public void executeUpdate(User user, String sql, PreparedStatementSetter pss) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setter(pstmt);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {     // pstmt가 null이 아니라면 자원 해제
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public Object executeQuery(String sql, PreparedStatementSetter pss, RowMapper rowMapper) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;    // 조회된 값을 받아오는 ResultSet

        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pss.setter(pstmt);
            rs = pstmt.executeQuery();

            Object obj = null;
            if (rs.next()) {     // 데이터베이스로 부터 값을 받아와서 값이 있으면 뽑아서 유저 객체를 만든다
               return rowMapper.map(rs);
            }
            return obj;
        } finally {     // 자원 해제는 역순으로
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }


}
