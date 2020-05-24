package cn.edu.aynu.date.demo1;

import cn.edu.aynu.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetTest {

    /*
    *传入一个日期能查看年份、月份、季度、日期、星期数、是哪一天
    */
    public static void main(String[] args) {
        //键盘录入日期
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入日期:(格式为yyyy-MM-dd)");
        String dateStr = sr.nextLine();
        //创建日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //将用户输入的日期字符串转换为日期格式
            Date date = dateFormat.parse(dateStr);
            //获取年份
            int year = DateUtil.getYear(date);
            //获取月份
            int month = DateUtil.getMonth(date);
            //获取季度
            int season = DateUtil.getSeason(date);
            //获取日期
            int d = DateUtil.getDate(date);
            //获取星期
            int week = DateUtil.getWeek(date);
            //是365天中的哪一天
            int num = DateUtil.getNum(date);
            System.out.println("您输入的日期是："+year+"年的第"+season+"季度"+"，"+month+"月份的"+d+"号星期"+week+"，已度过"+num+"天");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("请输入正确的日期格式！！！");
        }

    }


}
