package Study.Network_Study;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP练习
 */
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        bufferedWriter.write(scanner.nextLine());
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
