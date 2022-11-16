package Study.Reflection_Study;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-14 20:00
 * @Description 反射和File
 * 1、利用Class类的forName方法得到File类的class对象
 * 2、在控制台打印Flie类的所有构造器
 * 3、通过newInstance的方法创建File对象，并创建E:\mynew.txt文件
 */
public class HomeWork02 {
    public static void main(String[] args)throws Exception {
        Class<?> fileClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File的构造器="+declaredConstructor);
        }
        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        String filePath = "E:\\mynew.txt";
        Object file = declaredConstructor.newInstance(filePath);
        Method createNewFile = fileClass.getDeclaredMethod("createNewFile");
        createNewFile.invoke(file);
    }
}
