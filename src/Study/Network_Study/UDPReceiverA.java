package Study.Network_Study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 编写一个接收端A和一个发送端B
 * 接收端A在9999端口等待接收数据
 * 发送端B向接收端A发送数据“hello，明天吃火锅”
 * 接收端A接收到发送端B发送的数据，回复“好的，明天见”，再退出
 * 发送端B接收到回复的数据，再退出
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象，准备在9999端口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //2.构建DatagramPacket对象准备接收数据
        //DatagramPacket(byte[],int)
        byte[] buf = new byte[64*1024];//UDP一个数据包最大64kb
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //3.调用接收方法，接收DatagramPacket对象
        //  没有数据包过来时会阻塞，直至有数据包到达9999端口
        System.out.println("接收端A正在等待数据");
        datagramSocket.receive(datagramPacket);
        //4.对DatagramPacket进行拆包，取出数据
        int length = datagramPacket.getLength();//实际接收到数据的长度
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data,0,length));




        byte[] data2 = "好的，明天见".getBytes();
        DatagramPacket datagramPacket2 = new DatagramPacket(data2, data2.length, InetAddress.getLocalHost(), 9998);
        datagramSocket.send(datagramPacket2);




        //5.关闭资源
        datagramSocket.close();
        System.out.println("A端退出");
    }
}
