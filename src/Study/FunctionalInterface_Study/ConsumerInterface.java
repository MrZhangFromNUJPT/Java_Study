package Study.FunctionalInterface_Study;

import java.util.function.Consumer;

/**
 * @author ZhiPengZhang
 * @date 2022/10/26 18:56
 * @description Consumer接口accept()方法，及其andThen方法（多次消费）
 **/
public class ConsumerInterface {
    public static void main(String[] args) {
        String[] info = {"猪三,男", "狗四,女"};
        printInfo(info,
                s -> System.out.print("姓名：" + s.split(",")[0] + ","),
                s -> System.out.println("性别：" + s.split(",")[1]));
    }

    private static void printInfo(String info[], Consumer<String> con1, Consumer<String> con2) {
        for (String s : info) {
            //先执行con1再执行con2
            con1.andThen(con2).accept(s);
        }
    }
}
