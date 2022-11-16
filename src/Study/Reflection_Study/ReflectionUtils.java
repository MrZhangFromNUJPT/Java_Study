package Study.Reflection_Study;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-14 18:08
 * @Description 演示如何通过反射获取类的结构信息
 * Class类、Method类、Field类、Constructor类常用方法
 */
public class ReflectionUtils {
    //Class类方法
    @Test
    public void api_01() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass.getName());
        System.out.println(personClass.getSimpleName());
        //获取本类及父类所有public属性
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类的公有属性=" + field.getName());
        }
        //获取本类所有属性
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类所有属性=" + declaredField.getName());
        }
        //获取本类及父类所有public方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类的公有属性=" + method.getName());
        }
        //获取本类所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有属性=" + declaredMethod.getName());
        }
        //获取本类所有public构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类公有构造器=" + constructor.getName());
        }
        //获取本类所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器=" + declaredConstructor.getName());
        }
        //包信息
        System.out.println("包=" + personClass.getPackage());
        //以Class形式返回父类信息
        System.out.println("父类信息=" + personClass.getSuperclass());
        //接口信息
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息=" + anInterface);
        }
        //注解信息
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息=" + annotation);
        }
    }

    //Field类方法
    @Test
    public void api_02() {
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        //getModifiers()获取修饰符值
        //默认修饰符=0，public=1，private=2，protected=4，static=8
        //组合关系：public static = 1+8=9
        for (Field declaredField : declaredFields) {
            System.out.println("本类所有属性=" + declaredField.getName() +
                    "\n该属性的修饰符值=" + declaredField.getModifiers() +
                    "\n该属性的类型=" + declaredField.getType() + "\n");
        }

    }

    //Method类方法
    @Test
    public void api_03() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类所有方法=" + declaredMethod.getName() +
                    "\n该方法的修饰符值=" + declaredMethod.getModifiers() +
                    "\n该方法的返回值=" + declaredMethod.getReturnType());
            //当前这个方法的形参数组
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型 = " + parameterType);
            }
            System.out.println();
        }
    }

    //Constructor类方法
    @Test
    public void api_04() {
        Class<Person> personClass = Person.class;
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器=" + declaredConstructor.getName()+
                    "\n该方法的修饰符值=" + declaredConstructor.getModifiers());
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型 = " + parameterType);
            }
            System.out.println();
        }
    }
}

class A {
    public String hobby;

    public void hi() {
    }

    public A() {
    }
}

interface IA {
}

interface IB {
}

@Deprecated
class Person extends A implements IA, IB {
    //属性
    public String name;
    protected int age;
    String job;
    private double sal;

    //构造器
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //方法
    public void m1(String name, int age, double sal) {
    }

    protected String m2() {
        return new String();
    }

    void m3() {
    }

    private void m4() {
    }
}
