package Study.Network_Study;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 * 1、连接服务器（ip，端口）
 * 2、连接后，生成Socket，通过socket.getOutputStream()
 * 3、通过输出流，写入数据到数据通道
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //1、连接服务器（ip，端口）
        //连接本地9999端口，连接成功返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端socket返回="+socket.getClass());

        //2、连接后，生成Socket，通过socket.getOutputStream()
        //获得一个和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();

        //3、通过输出流，写入数据到数据通道
        outputStream.write("hello,server".getBytes());

        //4、关闭流对象和socket，必须关闭
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
