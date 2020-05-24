package cn.edu.aynu.io.demo1;

import java.io.File;
import java.io.FileFilter;

public class FileTest {

    /*
    *遍历当前目录下所有文件，包括子目录
    */

    //定义指定文件数量
    static int count = 0;
    public static void main(String[] args) {
        //创建file对象
        File file = new File("d://");
        //调用方法获得结果
        showAllFile(file);
        System.out.println("共有"+count+"个可执行文件");
    }

    private static void showAllFile(File file) {
        //获取该文件下的所有文件对象
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                //如果过滤的是目录直接放行
                if(pathname.isDirectory()){
                    return true;
                }
                //匹配上了对应文件直接放行
                if (pathname.isFile()) {
                    if (pathname.getName().endsWith(".exe")) {
                        return true;
                    }
                }
                return false;
            }
        });

        if(files!=null){
            //遍历文件数组
            for (File file1 : files) {
                //如果是文件
                if(file1.isFile()){
                    count++;
                    System.out.println(file1.getAbsolutePath());
                }else{
                    //表示遍历到的是目录，递归执行
                    showAllFile(file1);
                }
            }
        }
    }
}
