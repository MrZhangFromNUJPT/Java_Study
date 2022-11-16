package Study.Network_Study;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 * 文件上传
 */
public class TCPCopyFileClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建客户端
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //传输C盘上的文件到socket
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\鲁大师.png"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(buf)) != -1) {
            bos.write(buf, 0, readLen);
        }
        byte[] bytes = bos.toByteArray();//文件内容数组
        bufferedOutputStream.write(bytes);
        //传输完毕
        socket.shutdownOutput();
        //接收反馈
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭
        bufferedReader.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
    }
}
