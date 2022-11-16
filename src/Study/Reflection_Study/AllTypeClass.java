package Study.Reflection_Study;

import java.io.Serializable;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-12 19:29
 * @Description 演示哪些类型有Class对象
 */
public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> aClass1 = String.class;//外部类
        Class<Serializable> aClass2 = Serializable.class;//接口
        Class<Integer[]> aClass3 = Integer[].class;//数组
        Class<char[][]> aClass4 = char[][].class;
        Class<Override> aClass5 = Override.class;//注解
        Class<Thread.State> aClass6 = Thread.State.class;//枚举
        Class<Integer> aClass7 = int.class;//基本数据类型
        Class<Void> aClass8 = void.class;//void类型
        Class<Class> aClass9 = Class.class;//Class类
        System.out.println(aClass1);
        System.out.println(aClass2);
        System.out.println(aClass3);
        System.out.println(aClass4);
        System.out.println(aClass5);
        System.out.println(aClass6);
        System.out.println(aClass7);
        System.out.println(aClass8);
        System.out.println(aClass9);
    }
}
