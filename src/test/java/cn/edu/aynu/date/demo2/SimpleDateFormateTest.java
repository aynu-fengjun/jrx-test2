package cn.edu.aynu.date.demo2;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SimpleDateFormateTest {

    /*
    *按指定要求格式化日期
    */
    public static void main(String[] args){
        //调用菜单方法
        menu();
        //获取用户输入的格式
        String pattern = getPattern();
        //创建格式化日期对象
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        //将当前日期格式化为相应的字符串形式
        String dateStr = dateFormat.format(new Date());
        System.out.println("格式化后的日期："+dateStr);
    }

    /*菜单方法*/
    public static void menu(){
        System.out.println("请输入要转化的日期格式类型：");
        System.out.println("1:yyyy-MM-dd    2.yyyy-MM-dd HH:mm:ss   3.yyyy年MM月dd日   4.yyyy年MM月dd日HH时mm分ss秒");
    }

    /*获取用户输入的日期格式*/
    private static String getPattern() {
        String pattern = null;
        boolean flag = true;
        while(flag){
            Scanner sr = new Scanner(System.in);
            int num = sr.nextInt();
            switch (num) {
                case 1:
                    pattern = "yyyy-MM-dd";
                    flag = false;
                    break;
                case 2:
                    pattern = "yyyy-MM-dd HH:mm:ss";
                    flag = false;
                    break;
                case 3:
                    pattern = "yyyy年MM月dd日";
                    flag = false;
                    break;
                case 4:
                    pattern = "yyyy年MM月dd日HH时mm分ss秒";
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        return pattern;
    }

    @Test
    public void test(){
        //创建格式化日期对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("一年中的第 D 天 第w个星期 一月中第W个星期 在一天中k时 z时区");
        //将当前日期格式化为相应的字符串形式
        String dateStr = dateFormat.format(new Date());
        System.out.println("格式化后的日期："+dateStr);
    }
}

