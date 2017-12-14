package com.will.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * ClassName:DateTimeUtils
 * Description:基于JDK8 time包的时间工具类
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-13
 */
public final class DateTimeUtils {
    /**
     * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE.formatter;

    private DateTimeUtils() {
        // no construct function
    }

    /**
     * 获取指定时间的指定格式
     * @param time
     * @param pattern
     * @return
     */
    public static String formatTime(LocalDateTime time,String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取指定格式的当前时间
     * @param pattern
     * @return
     */
    public static String formatNow(String pattern) {
        return  formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 将输入字符串转换为LocalDateTime
     * @param timeStr = "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static LocalDateTime parseTime(String timeStr) {
        return LocalDateTime.parse(timeStr, DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * 将输入时间字符串以指定形式返回LocalDateTime
     * @param timeStr
     * @param format  时间格式
     * @return
     */
    public static LocalDateTime parseTime(String timeStr, TimeFormat format) {
        return LocalDateTime.parse(timeStr, format.formatter);
    }

    /**
     * 时间按默认格式转String，例：2017-12-14 12:00:00
     * @param time
     * @return
     */
    public static String parseTime(LocalDateTime time) {
        return DEFAULT_DATETIME_FORMATTER.format(time);
    }

    /**
     * 将输入时间以指定形式返回
     * @param time
     * @param format 时间格式
     * @return
     */
    public static String parseTime(LocalDateTime time, TimeFormat format) {
        return format.formatter.format(time);
    }

    /**
     * 获取默认格式的当前时间，例：2017-12-14 12:00:00
     * @return
     */
    public static String getCurrentDatetime() {
        return parseTime(LocalDateTime.now());
    }

    /**
     * 获取指定格式的当前时间
     * @param format 时间格式
     * @return
     */
    public static String getCurrentDatetime(TimeFormat format) {
        return parseTime(LocalDateTime.now(), format);
    }

    /**
     * Date转换为LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

    }

    /**
     * LocalDateTime转换为Date
     * @param time
     * @return
     */
    public static Date convertLocalDateTimeToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定日期的毫秒
     * @param time
     * @return
     */
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒
     * @param time
     * @return
     */
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
     * @param time
     * @param number
     * @param field 单位(年月日时分秒)
     * @return
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
     * @param time
     * @param number
     * @param field 单位(年月日时分秒)
     * @return
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field 单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 获取一天的开始时间，例：2017,12,14 00:00
     * @param time
     * @return
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取一天的结束时间，例：2017,12,14 23:59:59.999999999
     * @param time
     * @return
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    /**
     * 时间格式
     */
    public enum TimeFormat {
        /**
         * 短时间格式
         */
        SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),

        SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),

        SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),

        SHORT_DATE_PATTERN_NONE("yyyyMMdd"),

        /**
         * 长时间格式
         */
        LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),

        LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),

        LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),

        LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),

        /**
         * 长时间格式,带毫秒
         */
        LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),

        LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),

        LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),

        LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS");


        private transient DateTimeFormatter formatter;

        TimeFormat(String pattern) {
            this.formatter = DateTimeFormatter.ofPattern(pattern);
        }
    }
}
