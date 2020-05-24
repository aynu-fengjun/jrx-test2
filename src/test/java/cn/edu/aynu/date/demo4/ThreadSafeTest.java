package cn.edu.aynu.date.demo4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafeTest {

    public static void main(String[] args) {
        //时间格式化和解析是线程不安全的
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 30; i++) {
            //创建线程并启动
            new Thread(()->{
                try {
                    Date date = sdf.parse("2020-05-20");
                    System.out.println("date:"+date);
                }  catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
