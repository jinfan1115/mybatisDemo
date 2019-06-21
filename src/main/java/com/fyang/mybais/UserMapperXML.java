package com.fyang.mybais;

import java.util.HashMap;
import java.util.Map;

public class UserMapperXML {

    public static final String namespace = "com.fyang.mybais.UserMapper";

    private static Map<String,String> methodSqlMap = new HashMap<String,String>();

    static {
        methodSqlMap.put("finduUserById","select * from user where id=%s");
    }

    public static String getMethodSQL(String method){ return  methodSqlMap.get(method);};

}
