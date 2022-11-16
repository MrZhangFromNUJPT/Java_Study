package Study.Network_Study;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端发送并接收
 */
public class SocketTCP02Client {
        public static void main(String[] args) throws IOException {
            Socket socket = new Socket(InetAddress.getLocalHost(),9999);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello,server".getBytes());


            //写入结束标志
            socket.shutdownOutput();


            InputStream inputStream = socket.getInputStream();
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen=inputStream.read(buf))!=-1)
                System.out.println(new String(buf,0,readLen));

            outputStream.close();
            inputStream.close();
            socket.close();
            System.out.println("客户端退出...");
        }
}
