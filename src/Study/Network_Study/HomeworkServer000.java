package Study.Network_Study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *服务端和客户端互聊
 */
public class HomeworkServer000 {
    public static void main(String[] args) {
        try {
            // 连接到本机的8888端口
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器端，在9999端口监听，等待连接...");
            Socket s = serverSocket.accept();

            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            Scanner sc = new Scanner(System.in);
            Thread t1 = new Thread() {
                public void run() {
                    while (true) {
                        try {
                            String msg = dis.readUTF();
                            if (msg != null) {
                                System.out.println("收到服务端的消息:" + msg);
                            }
                        } catch (IOException e) {
                            // TODO 自动生成的 catch 块
                            e.printStackTrace();
                        }
                    }
                }
            };
            Thread t2 = new Thread() {
                public void run() {
                    while (true) {
                        try {
                            String str = sc.next();
                            // 使用writeUTF发送字符串
                            dos.writeUTF(str);
                        } catch (IOException e) {
                            // TODO 自动生成的 catch 块
                            e.printStackTrace();
                        }
                    }
                }
            };
            t1.start();
            t2.start();
            t1.join();
            System.out.println("关闭客户端");
            dis.close();
            dos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
