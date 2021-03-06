package com.will.datetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * ClassName:TimeUtilsTest
 * Description:测试间工具类
 *
 * @Author Will
 * @Email willwu618@gmail.com
 * @Date 2017-12-14
 */
public class TimeUtilsTest {
    public static void main(String[] args) {
        // 以默认形式返回当前时间
        System.out.println(DateTimeUtils.getCurrentDatetime());
        // 以指定形式返回当前时间
        System.out.println(DateTimeUtils.getCurrentDatetime(DateTimeUtils.TimeFormat.LONG_DATE_PATTERN_SLASH));
        // 以指定形式返回当前时间
        System.out.println(DateTimeUtils.formatNow("yyyy-MM-dd HH:mm:ss"));

        // 将输入时间以指定形式返回
        System.out.println(DateTimeUtils.formatTime(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
        // 将输入时间以默认形式返回
        System.out.println(DateTimeUtils.parseTime(LocalDateTime.now()));
        // 将输入时间以指定形式返回
        System.out.println(DateTimeUtils.parseTime(LocalDateTime.now(), DateTimeUtils.TimeFormat.SHORT_DATE_PATTERN_LINE));


        // 将输入字符串转换为LocalDateTime
        System.out.println(DateTimeUtils.parseTime("2017-01-01 00:00:00"));
        // 将输入时间字符串以指定形式返回LocalDateTime
        System.out.println(DateTimeUtils.parseTime("2017/01/01 00:00:00",
                DateTimeUtils.TimeFormat.LONG_DATE_PATTERN_SLASH));

        // Date转LocalDateTime
        System.out.println(DateTimeUtils.convertDateToLocalDateTime(new Date()));
        // LocalDateTime转Date
        System.out.println(DateTimeUtils.convertLocalDateTimeToDate(LocalDateTime.now()));

        // 获取输入时间的毫秒数
        System.out.println(DateTimeUtils.getMilliByTime(LocalDateTime.now()));
        // 获取输入时间的秒数
        System.out.println(DateTimeUtils.getSecondsByTime(LocalDateTime.now()));

        // 增加
        System.out.println(DateTimeUtils.plus(LocalDateTime.now(), 1, ChronoUnit.YEARS));
        // 减少
        System.out.println(DateTimeUtils.minu(LocalDateTime.now(), 1, ChronoUnit.MONTHS));

        // 获取两个日期的以某种形式（年，月，天...）的差
        System.out.println(DateTimeUtils.betweenTwoTime(LocalDateTime.now(),
                DateTimeUtils.parseTime("2017-01-01 00:00:00"), ChronoUnit.DAYS));

        // 获取输入日期的开始时刻
        System.out.println(DateTimeUtils.getDayStart(LocalDateTime.now()));
        // 获取输入日期的最后时刻
        System.out.println(DateTimeUtils.getDayEnd(LocalDateTime.now()));
    }
}
