package Study.Network_Study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP练习
 */
public class HomeWork02CServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket);
        int len = datagramPacket.getLength();
        String s = new String(datagramPacket.getData(),0,len);
        System.out.println("从客户端收到的问题："+s);
        String answer = new String();
        if("四大名著是哪些".equals(s))
            answer = "四大名著是《红楼梦》、《三国演义》、《西游记》和《水浒传》。";
        else
            answer = "what?";

        buf = answer.getBytes();
        DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8888);
        datagramSocket.send(datagramPacket1);

        datagramSocket.close();
        System.out.println("服务器退出");
    }
}
