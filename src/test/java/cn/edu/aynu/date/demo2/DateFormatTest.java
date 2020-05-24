package cn.edu.aynu.date.demo2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateFormatTest {

    /*
    *按指定要求格式化日期
    */
    public static void main(String[] args){
       //使用DateFormat去格式化时间
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance();
        System.out.println("格式化当前日期："+dateFormat.format(date));
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
        System.out.println("格式化当前具体时间："+dateTimeInstance.format(date));

        //日期的完整格式
        DateFormat dateInstance1 = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("当前时间完整格式："+dateInstance1.format(date));
        //日期的默认格式
        DateFormat dateInstance2 = DateFormat.getDateInstance(DateFormat.DEFAULT);
        System.out.println("当前时间默认格式："+dateInstance2.format(date));
        //日期的长格式
        DateFormat dateInstance3 = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("当前时间长格式："+dateInstance3.format(date));
    }


}

