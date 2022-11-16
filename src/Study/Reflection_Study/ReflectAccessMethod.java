package Study.Reflection_Study;

import java.lang.reflect.Method;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-14 19:40
 * @Description 演示通过反射调用方法
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws Exception {
        Class<?> bossClass = Class.forName("Study.Reflection_Study.Boss");
        Object o = bossClass.newInstance();
        //调用hi方法
        Method hi = bossClass.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "呆子");
        //调用say方法
        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);//暴破
        System.out.println(say.invoke(o, 100, "狗头", 'a'));
        System.out.println(say.invoke(null, 200, "猫头", 'b'));
        //在反射中，如果方法有返回值，统一返回Object
        Object returnValue = say.invoke(o, 20, "猪头", 'c');
        System.out.println("运行类型为" + returnValue.getClass());


    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi," + s);
    }
}
