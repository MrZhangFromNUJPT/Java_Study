package Study.Reflection_Study;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-12 18:21
 * @Description 对Class类特点梳理：
 * 1.Class也是类，继承Object类
 * 2.Class类不是new出来的，是系统创建的
 * 3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
 * 4.每个类的实例都会记得自己是由哪个Class实例所生成
 * 5.通过Class可以完整得到一个类的完整结构，通过一系列API
 * 6.Class类对象存放在堆中
 * 7.类的字节码二进制数据存放在方法区，有的地方成为类的元数据(包括方法代码、变量名、方法名、访问权限等)
 */
public class Class01 {
    public static void main(String[] args) throws Exception {
        //1.Class也是类，继承Object类
        //类图
        //2.Class类不是new出来的，是系统创建的
        /*
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //(1)传统方法
        Cat cat = new Cat();
        //(2)反射方法
        Class cat1 = Class.forName("Study.Reflection_Study.Cat");
        //3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        Class cat2 = Class.forName("Study.Reflection_Study.Cat");
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());//一样

    }
}
