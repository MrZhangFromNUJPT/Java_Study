package Study.Network_Study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP练习
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器正在监听...");
        Socket accept = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println(s);
        String answer = new String();
        if (s.equals("name"))
            answer = "nova";
        else if (s.equals("hobby"))
            answer = "编写Java程序";
        else
            answer = "你说啥呢";

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
        accept.close();
        serverSocket.close();
        System.out.println("服务器退出");
    }
}
