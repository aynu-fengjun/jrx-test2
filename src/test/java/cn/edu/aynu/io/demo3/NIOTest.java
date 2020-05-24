package cn.edu.aynu.io.demo3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest{
    public static void main(String[] args){
        FileChannel fcIn = null;
        FileChannel fcOut = null;
        try {
            //创建一个输入文件的通道
            fcIn = new FileInputStream("e://300.jpg").getChannel();
            //创建一个输出文件的通道
            fcOut = new FileOutputStream("e://test//300.jpg").getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //将通道中的数据读取到缓冲区
            while (fcIn.read(buf)!=-1){
                //切换写模式
                buf.flip();
                //将缓冲区中的数据读取到通道中
                fcOut.write(buf);
                buf.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输出流
            if(fcOut!=null){
                try {
                    fcOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭输入流
            if(fcIn!=null){
                try {
                    fcIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
