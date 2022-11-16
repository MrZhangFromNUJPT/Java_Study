package Study.Network_Study;

import java.io.IOException;
import java.net.*;

/**
 * 编写一个接收端A(9999端口)和一个发送端B(9998端口)
 * 接收端A在9999端口等待接收数据
 * 发送端B向接收端A发送数据“hello，明天吃火锅”
 * 接收端A接收到发送端B发送的数据，回复“好的，明天见”，再退出
 * 发送端B接收到回复的数据，再退出
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象,准备发送和接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        //将需要发送的数据封装到DatagramPacket对象
        byte[] data = "hello，明天吃火锅".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);

        byte[] buf = new byte[64*1024];
        datagramPacket = new DatagramPacket(buf, buf.length);
        System.out.println("接收端B正在等待数据");
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] data2 = datagramPacket.getData();
        System.out.println(new String(data2,0,length));

        //关闭资源
        datagramSocket.close();
        System.out.println("B端退出");
    }
}
