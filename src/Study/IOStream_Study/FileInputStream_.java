package Study.IOStream_Study;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }

    //单个字节读取，效率较低
    @Test
    public void readFile01() {
        String filePath = "e:\\hello.txt";
        int readData = 0;
        //创建fileInputStream对象，用于读取文件
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //返回-1表示读取结束
            while ((readData = fileInputStream.read()) != -1)
                System.out.print((char) readData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //使用read(byte[] b)读取文件，提高效率
    @Test
    public void readFile02() {
        String filePath = "e:\\hello.txt";
        byte[] buf = new byte[8]; //一次读取8个字节
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //如果读取正常，返回实际读取的字节数
            //返回-1表示读取结束
            while ((readLen = fileInputStream.read(buf)) != -1)
                System.out.print(new String(buf,0,readLen));//显示
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
