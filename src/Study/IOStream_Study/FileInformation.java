package Study.IOStream_Study;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {
        
    }
    @Test
    public void info(){
        File file = new File("e:\\new.txt");
        System.out.println("文件名："+file.getName());
        System.out.println("绝对路径："+file.getAbsolutePath());
        System.out.println("父级目录："+file.getParent());
        System.out.println("文件大小（字节）："+file.length());
        System.out.println("文件是否存在："+file.exists());
        System.out.println("文件是否是目录："+file.isDirectory());
    }
}
