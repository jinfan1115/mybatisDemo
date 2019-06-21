package com.fyang.mybais;

import com.fyang.bean.User;

public class Bootstrap {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        MySqlSession mySqlSession = new MyDefaultsSqlSession();

        UserMapper userMapper = mySqlSession.getMapper(UserMapper.class);

        User user = userMapper.finduUserById(1);
        System.out.println(user);
    }
}
