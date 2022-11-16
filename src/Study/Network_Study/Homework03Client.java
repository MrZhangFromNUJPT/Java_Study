package Study.Network_Study;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 文件下载
 */
public class Homework03Client {
    public static void main(String[] args) throws IOException {
        //1.指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入文件名：");
        String downLoadFileName = scanner.next();

        //2.连接服务器
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //3.输出文件名
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downLoadFileName.getBytes());
        socket.shutdownOutput();
        //4.读取服务器返回的文件并放入磁盘D
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\"+downLoadFileName+".txt"));
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = bufferedInputStream.read(buf)) != -1) {
            bufferedOutputStream.write(buf, 0, readLen);
        }
        //5.关闭资源
        outputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
    }
}
