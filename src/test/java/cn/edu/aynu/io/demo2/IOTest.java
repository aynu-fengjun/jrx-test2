package cn.edu.aynu.io.demo2;

import org.junit.Test;

import java.io.*;

public class IOTest {

    /*
    *文件的读取和写入，文本文件逐行读取和写入，数据量要超过10万行数据
    */
    @Test
    public void test(){
        //创建输入内容的文件对象
        File file = new File("e://info.txt");
        //判断文件是否存在，不存在创建该文件
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //创建输出内容的文件对象
        File file2 = new File("e://to.txt");
        if(!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try( OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
             BufferedWriter bw = new BufferedWriter(osw,10 * 1024 * 1024);
             //创建转换作用的输入流
             InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
             //创建具有缓冲作用的输入流
             BufferedReader br = new BufferedReader(isr);
             OutputStreamWriter outputStreamWriter= new OutputStreamWriter(new FileOutputStream(file2));
             BufferedWriter bufferedWriter= new BufferedWriter(outputStreamWriter,10 * 1024 * 1024);) {
            //写入数据
            for(int i=0;i<1000000;i++){
                bw.write("我是"+i);
                //执行换行
                bw.newLine();
            }
            //将缓冲区中的数据刷新到文件中
            bw.flush();
            String line;
            //从info文件中逐行读取
            while ((line=br.readLine())!=null){
                //读出to文件中
                bufferedWriter.write(line);
                //换行
                bufferedWriter.newLine();
            }
            //刷新缓冲区内容
            bufferedWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
