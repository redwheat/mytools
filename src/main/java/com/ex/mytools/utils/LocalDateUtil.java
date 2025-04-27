package com.ex.mytools.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 此工具类可以由hutool工具类代替，仅对缺少的功能做补充
 * @author RedWheat
 * @date 2024/12/12 8:36
 */
public class LocalDateUtil {
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    private static final Map<String, DateTimeFormatter> DATE_TIME_FORMATTER_CACHE = new HashMap<>();

    /**
     * 推进日期
     */
    public static String plusDay(String currentDate, Integer days) {
        if (currentDate == null || "".equals(currentDate)) {
            return currentDate;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(currentDate, dateTimeFormatter);
        LocalDate nextDate = localDate.plusDays(days);
        return nextDate.format(dateTimeFormatter);
    }

    /**
     * 推进时间LocalDate -> String
     */
    public static String plusDay(LocalDate currentDate, Integer days) {
        if (currentDate == null) {
            return "";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate nextDate = currentDate.plusDays(days);
        return nextDate.format(dateTimeFormatter);
    }

    /**
     * 拼接开始时间
     *
     * @param currentDate
     * @return
     */
    public static String concatBeginTime(String currentDate) {
        if (currentDate == null || "".equals(currentDate)) {
            return currentDate;
        }
        return currentDate + " 00:00:00";
    }

    /**
     * 拼接结束时间
     *
     * @param currentDate
     * @return
     */
    public static String concatEndTime(String currentDate) {
        if (currentDate == null || "".equals(currentDate)) {
            return currentDate;
        }
        return currentDate + " 23:59:59";
    }


    public static String format(LocalDateTime localDateTime,String format){
        if(localDateTime == null){
            return null;
        }
        DateTimeFormatter formatter = getDateTimeFormatter(format);
        String localDateTimeStr = localDateTime.format(formatter);
        return localDateTimeStr;
    }


    public static DateTimeFormatter getDateTimeFormatter(String format){
        if(!DATE_TIME_FORMATTER_CACHE.containsKey(format)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.CHINA);
            return formatter;
        }else{
            return DATE_TIME_FORMATTER_CACHE.get(format);
        }
    }
}
