package com.ex.mytools.utils;

import java.time.*;
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


    /**
     * 获取时间戳(ms), 基于中国标准时间（CST, UTC+8)
     *
     * @param localDateTime
     * @return
     */
    public static Long getEpochMilliSecond(LocalDateTime localDateTime) {
        // 定义 ZoneId 为 Asia/Shanghai，即中国标准时间 (CST)
        ZoneId zoneIdCst = ZoneId.of("Asia/Shanghai");

        // 将 LocalDateTime 转换为 ZonedDateTime 并设置为北京时间
        ZonedDateTime zonedDateTimeCst = localDateTime.atZone(zoneIdCst);

        // 将 ZonedDateTime 转换为 Instant
        Instant instant = zonedDateTimeCst.toInstant();

        // 获取时间戳毫秒数
        long timestampMillis = instant.toEpochMilli();

        return timestampMillis;
    }

    /**
     * 将时间戳(ms)转换为LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime epochMilliSecondToLocalDateTime(Long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2025, 5, 21, 0, 0, 0);
        LocalDateTime startTime = LocalDateTime.of(2025, 5, 21, 0, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2025, 5, 26, 23, 59, 59);

        boolean f = time.isAfter(startTime) && time.isBefore(endTime);
        System.out.println(f);

        Long epochMilliSecond = getEpochMilliSecond(time);
        System.out.println(epochMilliSecond);

        long timestamp = 1747813145331L;
        LocalDateTime localDateTime = epochMilliSecondToLocalDateTime(timestamp);
        System.out.println(localDateTime);

    }

}
