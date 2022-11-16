package Study.FunctionalInterface_Study;

import java.util.function.Function;

/**
 * @author ZhiPengZhang
 * @date 2022/10/26 19:43
 * @description Function接口的R apply(T t)将T类型数据转换为R类型数据，及其andThen方法（多次转换）
 **/
public class FunctionInterface {
    public static void main(String[] args) {
        System.out.println();
        String str  ="AAA,20";
        int b = zhuanHuan(str,
                s->s.split(",")[1],
                Integer::parseInt,
                i->i+100
                );
        System.out.println(b);
    }

    public static Integer zhuanHuan(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        return fun1.andThen(fun2).andThen(fun3).apply(s);
    }

}
