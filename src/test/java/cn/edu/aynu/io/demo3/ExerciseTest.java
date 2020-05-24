package cn.edu.aynu.io.demo3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ExerciseTest {

    static HashMap<String,String> map = new HashMap();
    static ArrayList<String> list = new ArrayList();
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        while(true){
            System.out.println("请输入你要查找的学号：");
            String stuNo = sr.next();
            if("exit".equals(stuNo)){
                break;
            }else{
                //创建文件对象
                File file = new File("e://studentInfo.txt");
                //
                try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                    String len;
                    //读取文件内容
                    while((len=br.readLine())!=null){
                        //将文件内容添加到list集合
                        list.add(len);
                    }
                    //打印出用户想要的信息
                    System.out.println(split(list,stuNo));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
    }

    public static String split(ArrayList<String> list,String stuNo){
        //遍历集合分割数据
        for (String str : list) {
            String[] arr = str.split("/");
            map.put(arr[0],arr[1]);
        }
        //获取Map对应键的集合
        Set<String> keySet = map.keySet();
        for(String str: keySet){
            //循环判断两个的值是否一致
            if(stuNo.equals(str)){
                //一致返回数据信息
                return map.get(str);
            }
        }
        return "没有该学生！！！";
    }
}
