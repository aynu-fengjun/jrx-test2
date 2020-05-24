package cn.edu.aynu.date.demo3;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    /*
    *对日期进行相关操作，增、减小时、月份、日期
    */
    @Test
    public void test(){
        //获取当前时间
        Date date = new Date();
        //格式化时间
        String dateStr = parseDate(date);
        System.out.println("当前系统时间为："+dateStr);
        //获取Calendar实例对象
        Calendar instance = Calendar.getInstance();
        //设置当前时间
        instance.setTime(date);
        instance.add(Calendar.HOUR,2);
        System.out.println("两个小时后的时间："+parseDate(instance.getTime()));
        instance.add(Calendar.DAY_OF_MONTH,-7);
        System.out.println("一周前的日期为："+parseDate(instance.getTime()));
        instance.add(Calendar.MONTH,3);
        System.out.println("三个月后的时间："+parseDate(instance.getTime()));


    }

    private String parseDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }


}
