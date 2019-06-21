package com.fyang.mybais;

import java.lang.reflect.Proxy;

public class MyDefaultsSqlSession implements MySqlSession {

    private MyExecutor myExecutor = new MyBaseExecutor();
    @Override
    public <T> T selectOne(String var) {
        return myExecutor.query(var);
    }

    @Override
    public <T> T getMapper(Class<T> interfaces) {
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(),new Class[]{interfaces},new MyMapperProxy(this));
    }
}
