package Study.IOStream_Study;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args)  {

    }
    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\a.txt";
        FileReader fileReader = new FileReader(filePath);
        int data;
        while((data=fileReader.read())!=-1)
            System.out.print((char)data);
        if(fileReader!=null)
            fileReader.close();
    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "e:\\a.txt";
        FileReader fileReader = new FileReader(filePath);
        int dataLen;
        char[] buf = new char[8];
        while((dataLen=fileReader.read(buf))!=-1)
            System.out.print(new String(buf,0,dataLen));
        if(fileReader!=null)
            fileReader.close();
    }

}
