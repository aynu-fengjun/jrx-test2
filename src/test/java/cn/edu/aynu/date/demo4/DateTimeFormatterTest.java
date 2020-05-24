package cn.edu.aynu.date.demo4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterTest {

    public static void main(String[] args) {
        //DateTimeFormatter:格式化或解析日期，时间，类似于SimpleDateFormat
        //方式一：预定义得标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期--->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime);
        System.out.println(str);

        //解析：字符串-->日期
        TemporalAccessor parse = formatter.parse("2020-05-18T15:42:18.797");
        System.out.println(parse);

        //方式二：本地化相关的格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);


        //方式三：自定义的格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String str4 = formatter2.format(LocalDateTime.now());
        System.out.println(str4);
    }
}
