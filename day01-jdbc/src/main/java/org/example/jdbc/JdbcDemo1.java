package org.example.jdbc;

import java.sql.*;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/6/23
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDB", "root", "password");

        PreparedStatement pstm = connection.prepareStatement("select * from tb_user");
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
        resultSet.close();
        pstm.close();
        connection.close();
    }
}
