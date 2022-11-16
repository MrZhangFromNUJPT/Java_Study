package Study.Annotation_Study;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-16 20:11
 * @Description 简单的测试框架
 * 当主方法执行后，会自动执行被检测的所有方法（被Check注解的方法），判断方法是否有异常，记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //创建计算器对象
        Calculator c = new Calculator();
        //获取字节码文件对象
        Class cls = c.getClass();
        //获取所有方法
        Method[] methods = cls.getDeclaredMethods();

        int number = 0;//出现异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Study\\Annotation_Study\\bug.txt"));

        for (Method method : methods) {
            //判断方法上是否有Check注解
            if (method.isAnnotationPresent(Check.class)) {//有，执行
                try {
                    method.invoke(c);
                } catch (Exception e) {//捕获异常，记录到文件中
                    bw.write(method.getName() + "方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称是:" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因是+" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-------------");
                    bw.newLine();
                    number++;
                }
            }
        }
        bw.write("本次测试一共出现 " + number + " 次异常");
        bw.flush();
        bw.close();
    }
}
