package Study.Network_Study;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * UDP练习
 */
public class HomeWork02Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入问题：");
        String s = scanner.next();
        byte[] question = s.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(question, question.length, InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);

        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket1);
        int len = datagramPacket1.getLength();
        byte[] answer = datagramPacket1.getData();
        System.out.println(new String(answer,0,len));

        datagramSocket.close();
        System.out.println("客户端退出");
    }
}
