package Study.Network_Study;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 用字符流实现02内容
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //写
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server");
        bufferedWriter.newLine();//插入换行符，表示写入内容结束；要求对方使用readLine()来读！！！！
        bufferedWriter.flush();//字符流需要手动刷新
        //读
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
