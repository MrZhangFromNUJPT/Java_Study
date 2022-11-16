package Study.IOStream_Study;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    @Test
    public void writerFile01() throws IOException {
        String filePath = "e:\\a.txt";
        FileWriter fileWriter = new FileWriter(filePath,true);
        fileWriter.write("\n猪头们");
        fileWriter.close();
    }
}
