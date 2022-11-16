package Study.Reflection_Study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-14 19:27
 * @Description 演示反射操作属性
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class<?> stuClass = Class.forName("Study.Reflection_Study.Student");
        //创建对象
        Constructor<?> constructor = stuClass.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);
        //反射得到age属性对象
        Field age = stuClass.getField("age");
        age.set(o,88);//通过反射操作属性
        System.out.println(age.get(o));
        System.out.println(o);
        //反射操作name属性
        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);//暴破获取private属性
        name.set(o,"猪头");//或者name.set(null,"猪头")，因为name是static的
        System.out.println(name.get(o));//或者name.get(null)
        System.out.println(o);
    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}
