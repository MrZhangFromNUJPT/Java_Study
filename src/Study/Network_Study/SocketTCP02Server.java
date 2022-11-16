package Study.Network_Study;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器接收并发送
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端，在9999端口监听，等待连接...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while((readLen=inputStream.read(buf))!=-1)
            System.out.println(new String(buf,0,readLen));
        outputStream.write("hello,client".getBytes());

        //写入结束标志
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();//关闭服务器端
        System.out.println("服务器端关闭...");
    }
}
