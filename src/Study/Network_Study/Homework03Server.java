package Study.Network_Study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件下载
 */
public class Homework03Server {
    public static void main(String[] args) throws IOException {
        //1.监听并等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        //2.读取客户端发送的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        while ((len = inputStream.read(b)) != -1) {
            downLoadFileName += new String(b, 0, len);
        }
        System.out.println("客户端希望下载的文件名 = " + downLoadFileName);
        String resFileName = "";
        if ("鲁大师".equals(downLoadFileName))
            resFileName = "src/Study/Network_Study/鲁大师.png";
        else
            resFileName = "src/Study/Network_Study/默认.pdf";
        //3.将文件转成byte数组
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(buf)) != -1) {
            bos.write(buf, 0, readLen);
        }
        byte[] bytes = bos.toByteArray();
        //4.发送文件
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();
        //5.关闭资源
        inputStream.close();
        bufferedInputStream.close();
        bos.close();
        bufferedOutputStream.close();
        socket.close();
    }
}
