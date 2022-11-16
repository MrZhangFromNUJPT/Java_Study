package Study.Reflection_Study;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-12 18:21
 * @Description
 */
public class Reflection01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //类加载
        Class c = Class.forName("Study.Reflection_Study.Cat");
        //创建实例
        Object o = c.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());
        //获得方法
        Method m = c.getMethod("hi");
        //优化，在反射调用时取消访问检测
        m.setAccessible(true);
        //调用方法
        m.invoke(o);
    }
}
