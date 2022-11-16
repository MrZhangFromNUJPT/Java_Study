package Study.IOStream_Study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩程序
 * @author young
 *
 */
public class ZipStream {
    public static void main(String[] args) {
        File file = new File("e:/test.txt");
        FileInputStream fis = null;
        ZipOutputStream zos = null;
        try {
            fis = new FileInputStream(file);
            zos = new ZipOutputStream(new FileOutputStream("e:/my.zip"));

            // 创建压缩文件中的条目
            ZipEntry entry = new ZipEntry(file.getName());
            // 将创建好的条目加入到压缩文件中
            zos.putNextEntry(entry);
            // 写入当前条目所对应的具体内容
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = fis.read(buff)) != -1) {
                zos.write(buff, 0, len);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                zos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
