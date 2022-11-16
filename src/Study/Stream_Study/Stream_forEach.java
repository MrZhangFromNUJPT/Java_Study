package Study.Stream_Study;

import java.util.stream.Stream;

/**
 * @author ZhiPengZhang
 * @date 2022/10/26 20:31
 * @description
 * void forEach(Consumer<? super T> action)
 * forEach方法用来遍历流中的数据，是一个终结方法（遍历之后就不能继续调用流中的其他方法）
 **/
public class Stream_forEach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三", "李四", "王五");
        stream.forEach(s-> System.out.println(s));
    }
}
