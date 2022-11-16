package Study.Network_Study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class TCPCopyFileServer {
    public static void main(String[] args) throws IOException {
        //创建服务器端
        ServerSocket serverSocket = new ServerSocket(8888);
        //监听端口
        System.out.println("等待连接");
        Socket socket = serverSocket.accept();
        //从socket读数据写入D盘
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\鲁大师.png"));
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(buf)) != -1) {
            bufferedOutputStream.write(buf, 0, readLen);
        }
        System.out.println("接收成功");
        //回复客户端
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片！");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        socket.shutdownOutput();
        //关闭
        bufferedInputStream.close();
        bufferedOutputStream.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
