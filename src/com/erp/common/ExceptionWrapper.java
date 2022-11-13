package com.erp.common;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExceptionWrapper {
    public static Map<String, String> getError(Exception e) {
        Map<String, String> map = new HashMap<>();
        if (e instanceof SQLException) {
            map.put("msg", "database error");
            map.put("code", "101");
            return map;
        } else if (e instanceof ArithmeticException) {
            map.put("msg", "logical error");
            map.put("code", "102");
            return map;
        } else if (e instanceof NullPointerException) {
            map.put("msg", "init error");
            map.put("code", "103");
            return map;
        } else {
            map.put("msg", "connect to support team");
            map.put("code", "400");
            return map;
        }
    }
}
