package Study.IOStream_Study;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //1.创建文件输入流，将文件读入程序
        //2.创建文件输出流，
        //文件1---输入流--->java程序---输出流--->文件2
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        fileInputStream = new FileInputStream("e:111.JPG");
        fileOutputStream = new FileOutputStream("d:\\111.JPG");
        byte[] buf = new byte[1024];
        int readLen = 0;
        //边读边写
        while((readLen=fileInputStream.read(buf))!=-1){
            fileOutputStream.write(buf,0,readLen);//必须这个方法
        }
        System.out.println("拷贝成功");
        if(fileInputStream!=null)
            fileInputStream.close();
        if(fileOutputStream!=null)
            fileOutputStream.close();
    }
}
