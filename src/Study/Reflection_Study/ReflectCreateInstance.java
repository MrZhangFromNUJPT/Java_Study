package Study.Reflection_Study;

import java.lang.reflect.Constructor;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-14 18:57
 * @Description 通过反射机制创建实例
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws Exception {
        //获取User类的Class对象
        Class<?> userClass = Class.forName("Study.Reflection_Study.User");
        //通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //通过public的有参构造器创建实例
        Constructor<?> constructor = userClass.getConstructor(String.class);
        Object o1 = constructor.newInstance("猪头");
        System.out.println(o1);
        //通过非public的有参构造器创建实例☆☆☆
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);//暴破，使用反射访问private构造器
        Object o2 = declaredConstructor.newInstance(1000,"呆子");
        System.out.println(o2);
    }
}

class User {
    private int age=10;
    private String name="猫";

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User[age=" + age + ", name=" + name + "]";
    }
}
