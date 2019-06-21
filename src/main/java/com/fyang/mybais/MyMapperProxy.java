package com.fyang.mybais;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy implements InvocationHandler {

    private MySqlSession mySqlSession;

    public MyMapperProxy(){

    }
    public MyMapperProxy(MySqlSession mySqlSession){
        this.mySqlSession = mySqlSession;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       String mapperClass = method.getDeclaringClass().getName();
       if(UserMapperXML.namespace.equals(mapperClass)){
           String methodName = method.getName();
           String originSql = UserMapperXML.getMethodSQL(methodName);

           String formattedSql = String.format(originSql,String.valueOf(args[0]));
           return mySqlSession.selectOne(formattedSql);
       }
       return null;
    }
}
