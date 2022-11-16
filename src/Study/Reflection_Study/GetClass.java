package Study.Reflection_Study;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-12 19:13
 * @Description 得到Class对象的各种方式
 */
public class GetClass {
    public static void main(String[] args) throws Exception {
        //1.Class.forName();多用于配置文件，读取类全路径，加载类
        String classAllPath = "Study.Reflection_Study.Cat";
        Class<?> aClass = Class.forName(classAllPath);
        System.out.println(aClass);

        //2.类名.class();多用于参数传递
        Class<Cat> aClass1 = Cat.class;
        System.out.println(aClass1);

        //3.对象.getClass();适用于有对象实例的情况
        Cat cat = new Cat();
        Class<? extends Cat> aClass2 = cat.getClass();
        System.out.println(aClass2);

        //4.classLoader.loadClass();类加载器[4种]
        //(1)得到类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> aClass3 = classLoader.loadClass(classAllPath);
        System.out.println(aClass3);

        System.out.println(aClass.hashCode());
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());

        //5.基本数据类型.class
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        System.out.println(integerClass + "   " + characterClass);

        //6.基本数据类型包装类.TYPE
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

        System.out.println(integerClass.hashCode());
        System.out.println(type.hashCode());
    }
}
