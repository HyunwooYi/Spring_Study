package org.example;

import java.sql.*;

public class UserDao {

    public void create(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(user, sql, pstmt -> {
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

        });
    }

    public User findByUserId(String userid) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "SELECT userId, password, name, email FROM USERS WHERE userid = ?";
        return (User) jdbcTemplate.executeQuery(sql,
                pstmt -> pstmt.setString(1, userid),
                resultSet -> new User(
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("userId"),
                        resultSet.getString("email")
                ));
    }
}
