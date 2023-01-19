package org.example;

import java.sql.*;

public class UserDao {
    private Connection getConnection() {
        String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
        String id = "sa";
        String pw = "";

        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(url, id, pw);
        } catch (Exception ex) {
            return null;
        }
    }


    public void create(User user) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            String sql =  "INSERT INTO USERS VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

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

    public User findByUserId(String userid) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;    // 조회된 값을 받아오는 ResultSet

        try {
            con = getConnection();
            String sql = "SELECT userId, password, name, email FROM USERS WHERE userid = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userid);    // 첫번쨰 ? 에 userId가 들어간다

            rs = pstmt.executeQuery();

            User user = null;
            if (rs.next()) {     // 데이터베이스로 부터 값을 받아와서 값이 있으면 뽑아서 유저 객체를 만든다
                user = new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
            return user;
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
