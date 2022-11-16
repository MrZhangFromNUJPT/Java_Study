package Study.Network_Study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 用字符流实现02内容
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端，在9999端口监听，等待连接...");
        Socket socket = serverSocket.accept();
        //读
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();//readLine()
        System.out.println(s);
        //写
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        //关闭
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();//关闭服务器端
        System.out.println("服务器端关闭...");
    }
}
