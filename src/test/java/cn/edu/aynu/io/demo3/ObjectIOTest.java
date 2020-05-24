package cn.edu.aynu.io.demo3;

import org.junit.Test;

import java.io.*;

public class ObjectIOTest {

    /*
     * 将对象反序列化
     */
    @Test
    public void outObject(){
        //创建文件输出流
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("e://object.txt");
            //创建对象输出流
            oos = new ObjectOutputStream(fos);
            //有参构造赋值
            Person boy = new Person("Peter",12);
            //写出数据
            oos.writeObject(boy);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                //关流
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
     * 将对象序列化转换为对象
     */
    @Test
    public void testOIS(){
        //创建文件输入流
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("e://object.txt");
            //创建对象输入流
            ois = new ObjectInputStream(fis);
            //读取二进制文件转换成对象
            Person boy = (Person)ois.readObject();
            System.out.println(boy);
            //关流
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


