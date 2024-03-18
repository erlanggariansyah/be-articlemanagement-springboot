package com.erlanggariansyah.articlemanagement.util;

public class LogUtil {
    public static String startLog(String methodName, String className) {
        return "Start executing " + methodName + " from " + className;
    }

    public static String endLog(String methodName, String className) {
        return "End executing " + methodName + " from " + className;
    }
}
