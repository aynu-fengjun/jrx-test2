package cn.edu.aynu.date.demo4;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTest {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 获取localDate对象
        LocalDate date2 = LocalDate.of(2020, 05, 20);
        LocalDate date3 = LocalDate.parse("2020-05-20");

        // 当前当前日期年份：2020
        System.out.println(today.getYear());
        // 当前日期月份对象：MAY
        System.out.println(today.getMonth());
        // 当前日期月份：5
        System.out.println(today.getMonthValue());
        // 该日期是当前周的第几天:6
        System.out.println(today.getDayOfWeek().getValue());
        // 该日期是当前月的第几天:23
        System.out.println(today.getDayOfMonth());
        // 该日期是当前年的第几天:144
        System.out.println(today.getDayOfYear());
        // 修改该日期的年份：2021-05-23
        System.out.println(today.withYear(2021));
        // 修改该日期的月份：2020-12-23
        System.out.println(today.withMonth(12));
        // 修改该日期在当月的天数：2019-05-01
        System.out.println(today.withDayOfMonth(1));
        // 判断是否是闰年：true
        System.out.println(today.isLeapYear());
        // 当前年份有多少天：366
        System.out.println(today.lengthOfYear());
        // 当前月份有多少天：31
        System.out.println(today.lengthOfMonth());
        // 比较该日期与date2日期的大小，返回正数，那么当前对象时间较晚（数字较大）:3
        int i = today.compareTo(date2);
        System.out.println(i);
        // 比较该日期是否比参数日期早（true为早）:false
        System.out.println(today.isBefore(date2));
        // 比较该日期是否比参数日期晚（true为晚）:true
        System.out.println(today.isAfter(date2));
        // 比较两个日期是否相等:true
        System.out.println(today.isEqual(LocalDate.now()));
        // 当前日期增加指定的年数:2021-05-23
        System.out.println(today.plusYears(1));
        // 当前日期增加指定的月份:2021-07-23
        System.out.println(today.plusMonths(2));
        // 当前日期增加指定的周数:2021-06-06
        System.out.println(today.plusWeeks(2));
        // 当前日期增加指定的天数:2021-05-30
        System.out.println(today.plusDays(7));
        // 当前日期减少指定的年数:2019-05-23
        System.out.println(today.minusYears(1));
        // 当前日期减少指定的月份:2020-04-23
        System.out.println(today.minusMonths(1));
        // 当前日期减少指定的周数:2020-05-16
        System.out.println(today.minusWeeks(1));
        //  当前日期减少指定的天数:2020-05-08
        System.out.println(today.minusDays(15));

        // LocalDate 转 String
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = today.format(dateTimeFormatter);

        // String 转 LocalDate
        String str = "2010-10-01";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(str, fmt);

        // Date 转 LocalDate
        Date now = new Date();
        // 先将java.util.Date转换为ZonedDateTime
        Instant instant = now.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        // 使用它的toLocalDate（）方法从ZonedDateTime获取LocalDate。
        LocalDate localDate = zonedDateTime.toLocalDate();
        System.out.println(now);
        System.out.println(localDate);

        // LocalDate 转 Date
        ZoneId id = ZoneId.systemDefault();
        LocalDate now1 = LocalDate.now();
        ZonedDateTime dateTime = now1.atStartOfDay(id);
        Date date1 = Date.from(dateTime.toInstant());
        System.out.println(date1);

    }

}
