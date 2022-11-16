package Study.Network_Study;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress演示
 */
public class InetAddress_Show {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost:" + localHost);

        //根据指定主机名 获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-HHII4G5");
        System.out.println("host1:" + host1);

        //根据域名 获取InetAddress对象 比如百度
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2:" + host2);

        //通过InetAddress获取对应地址
        System.out.println("host2 对应的ip地址" + host2.getHostAddress());
        //通过InetAddress获取对应主机名或域名
        System.out.println("host2 对应的主机名或域名" + host2.getHostName());
    }
}
