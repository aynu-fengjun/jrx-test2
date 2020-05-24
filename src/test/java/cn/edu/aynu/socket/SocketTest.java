package cn.edu.aynu.socket;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public class SocketTest {

    @Test
    public void socketTest() throws IOException {
        String host = "www.baidu.com";
        int port = 80;
        //创建本地文件对象
        File file = new File("e:\\socket.txt");
        //创建Socket对象
        Socket socket = new Socket(InetAddress.getByName(host), port);
        //获得输出流
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        BufferedWriter bw = new BufferedWriter(osw);
        //编辑请求头
        bw.write("GET / HTTP/1.1\r\n");
        bw.write("Connection: Keep-Alive\r\n");
        bw.write("Host: www.baidu.com\r\n");
        bw.write("Connection: Keep-Alive\r\n\r\n");
        //刷新缓冲区内容
        bw.flush();
        //关闭客户端输出流
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        String str = null;
        while ((str = br.readLine()) != null) {
            //写出数据到socket文件
            bufferedWriter.write(str);
            //换行
            bufferedWriter.newLine();
        }
        //关闭socket连接
        socket.close();
    }

    @Test
    public void URLTest() {
        // 保存原来的标准输出流
        PrintStream out = System.out;
        PrintStream ps = null;
        try {
            File file = new File("e://网页内容.txt");
            // 新建打印流
            ps = new PrintStream(file);
            // 输出重定向
            System.setOut(ps);
            URL url = new URL(
                    "https://www.sohu.com/a/238246281_100109711");
            InputStream input = null; // 打开输入流
            input = url.openStream();
            Scanner scan = new Scanner(input); // 实例化Scanner类
            scan.useDelimiter("\n"); // 设置读取分隔符
            while (scan.hasNext()) {
                System.out.println(scan.next());
            }
            //恢复标准输出流
            System.setOut(out);
            System.out.println("输出完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


