package Study.IOStream_Study;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class Directory_ {
    public static void main(String[] args) {

    }

    @Test
    public void m1() {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }
    }

    //java中目录当做文件看待
    @Test
    public void m2() {
        String filePath = "e:\\demo";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else
            System.out.println("目录不存在");
    }

    @Test
    public void m3() {
        String filePath = "e:\\demo\\a\\b\\c";
        File file = new File(filePath);
        if (!file.exists()) {
            if (file.mkdirs())
                System.out.println("创建成功");
            else
                System.out.println("创建失败");
        } else
            System.out.println("目录已经存在");
    }
}
