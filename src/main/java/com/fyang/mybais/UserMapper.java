package com.fyang.mybais;

import com.fyang.bean.User;

public interface UserMapper {
    public User finduUserById(int id);
    public void insertUser(User user);
}
