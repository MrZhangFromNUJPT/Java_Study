package Study.Reflection_Study;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author NJUPT_MR.Z
 * @create 2022-05-14 19:53
 * @Description
 */
public class HomeWork01 {
    public static void main(String[] args) throws Exception {
        Class<?> priClass = Class.forName("Study.Reflection_Study.PrivateTest");
        Object o = priClass.newInstance();
        Field name = priClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "你好");
        Method getName = priClass.getDeclaredMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);
    }
}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}
