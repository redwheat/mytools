package com.ex.mytools.utils;

/**
 * @author RedWheat
 * @date 2025/2/12 10:13
 */
public class StringUtils {
    public static final String EMPTY = "";

    private StringUtils() {}

    public static boolean isEmpty(Object str) {
        return (str == null || EMPTY.equals(str));
    }
}
