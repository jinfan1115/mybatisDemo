package com.fyang.mybais;

public interface MySqlSession {
    <T> T selectOne(String var);
    <T> T getMapper(Class<T> var);
}
