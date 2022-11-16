package Study.Reflection_Study;

import java.lang.reflect.Field;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-12 18:58
 * @Description 演示Class类常用方法
 */
public class Class02 {
    public static void main(String[] args) throws Exception {
        String classAllPath = "Study.Reflection_Study.Cat";
        //1.获取Class对象
        Class<?> cls = Class.forName(classAllPath);//<?>表示不确定Java类型，可去掉
        //2.输出Class
        System.out.println(cls);//哪个类的class对象
        System.out.println(cls.getClass());//运行类型
        //3.得到包名
        System.out.println(cls.getPackage().getName());
        //4.得到类名
        System.out.println(cls.getName());
        //5.生成对象实例
        Object o = cls.getDeclaredConstructor().newInstance();
        //6.通过反射获取属性
        Field age = cls.getField("age");//公有属性
        System.out.println(age);
        //7.给属性设置值
        age.set(o,10);
        System.out.println(age.get(o));
        //8.得到所有公有属性
        Field[] fields = cls.getFields();
        for (Field f: fields) {
            System.out.println(f);
        }
    }
}
