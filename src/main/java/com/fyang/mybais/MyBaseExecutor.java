package com.fyang.mybais;

import com.fyang.bean.User;

import java.sql.*;

public class MyBaseExecutor implements MyExecutor {

    private String CONNECTIONURL = "jdbc:mysql://172.16.6.103:3306/fl_account";
    private String USERNAME = "pdclease";
    private String PASSWORD = "pdclease";

    static{
        // 1.注册驱动
        try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Override
    public <T> T query(String statement) {
        //操作JDBC
        Connection conn = null;
        PreparedStatement pers = null;
        ResultSet resultSet = null;
        try {
            conn = DriverManager.getConnection(CONNECTIONURL,USERNAME,PASSWORD);
            String sql = statement;
            pers = conn.prepareStatement( sql );
            resultSet = pers.executeQuery();

            User user = null;
            if(resultSet.next()){
                user = new User();
                user.setName( resultSet.getString("name") );
                user.setLoginName( resultSet.getString("login_name") );
                user.setPassword( resultSet.getString( "password" ) );
            }
             return (T) user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
