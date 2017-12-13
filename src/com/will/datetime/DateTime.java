package com.will.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * ClassName:DateTime
 * Description:Jdk8新特性-Date API
 * @Author Will Wu
 * @Email willwu618@gmail.com
 * @Date 2017-12-12
 */
public class DateTime {

    /**
     *（一） Clock 时钟
     * Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
     * 某一个特定的时间点也可以使用Instant类来表示，Instant类也可以用来创建老的java.util.Date对象。
     */
    public static void clock() {
        // 使用系统默认时区
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis + ":" + System.currentTimeMillis());
        Instant instant = clock.instant();
        // legacy java.util.Date
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate + ":" + new Date());
    }

    /**
     *（二）Timezones 时区
     * 在新API中时区使用ZoneId来表示。时区可以很方便的使用静态方法of来获取到。
     * 时区定义了到UTS时间的时间差，在Instant时间点对象到本地日期对象之间转换的时候是极其重要的。
     */
    public static void timeZones() {
        //输出所有的时区
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        //输出ZoneRules[currentStandardOffset=+01:00]
        System.out.println(zone1.getRules());
        //输出ZoneRules[currentStandardOffset=-03:00]
        System.out.println(zone2.getRules());
    }

    /**
     *（三）LocalTime 本地时间
     * LocalTime 定义了一个没有时区信息的时间，例如 晚上10点，或者 17:30:15。
     * 下面的例子使用前面代码创建的时区创建了两个本地时间。之后比较时间并以小时和分钟为单位计算两个时间的时间差.
     */
    public static void localTime() {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));
        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween);
        System.out.println(minutesBetween);

        // LocalTime 提供了多种工厂方法来简化对象的创建，包括解析时间字符串。
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);
        DateTimeFormatter germanFormatter = DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);

        Clock clock = Clock.systemDefaultZone();
        // Get the local date and local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);

        System.out.println(time);
        System.out.println(timeFromClock);
    }

    /**
     * （四）LocalDate 本地日期
     * LocalDate 表示了一个确切的日期，比如 2014-03-11。该对象值是不可变的，用起来和LocalTime基本一致。
     * 下面的例子展示了如何给Date对象加减天/月/年。另外要注意的是这些对象是不可变的，操作返回的总是一个新实例。
     */
    public static void localDate() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(yesterday);
        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

        DateTimeFormatter germanFormatter1 =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);
        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter1);
        System.out.println(xmas);

        Clock clock = Clock.systemDefaultZone();
        // Get the local date and local time
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);

        System.out.println(date);
        System.out.println(dateFromClock);
    }

    /**
     * （五）LocalDateTime 本地日期时间
     * LocalDateTime 同时表示了时间和日期，相当于前两节内容合并到一个对象上了。
     * LocalDateTime和LocalTime还有LocalDate一样，都是不可变的。LocalDateTime提供了一些能访问具体字段的方法。
     */
    public static void localDateTime() {
        Clock clock = Clock.systemDefaultZone();
        // Get the local date/time
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );

        System.out.println( datetime );
        System.out.println( datetimeFromClock );

        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek1);
        Month month = sylvester.getMonth();
        System.out.println(month);
        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);
        /**
         * 只要附加上时区信息，就可以将其转换为一个时间点Instant对象，Instant时间点对象可以很容易的转换为老式的java.util.Date。
         */
        Instant instant1 = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();
        Date legacyDate1 = Date.from(instant1);
        System.out.println(legacyDate1);

        /**
         * 格式化LocalDateTime和格式化时间和日期一样的，除了使用预定义好的格式外，我们也可以自己定义格式：
         */
        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("06 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);

        //和java.text.NumberFormat不一样的是新版的DateTimeFormatter是不可变的，所以它是线程安全的。
        //关于时间日期格式的详细信息：http://download.java.net/jdk8/docs/api/java/time/format/DateTimeFormatter.html
        //java jdk1.8新提供的这个time在某些时候还是有好处的
    }

    /**
     *（六） Duration类
     * Duration使计算两个日期间的不同变的十分简单
     */
    public static void duration() {
        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);

        final Duration duration = Duration.between(from, to);
        System.out.println( "Duration in days: " + duration.toDays());
        System.out.println( "Duration in hours: " + duration.toHours());
    }

    public static void main(String[] args) {
//        clock();
//        timeZones();
//        localTime();
//        localDate();
//        localDateTime();
        duration();
    }

}
