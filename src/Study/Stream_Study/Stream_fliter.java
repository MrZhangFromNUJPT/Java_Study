package Study.Stream_Study;

import java.util.stream.Stream;

/**
 * @author ZhiPengZhang
 * @date 2022/10/26 20:37
 * @description
 * Stream<T> fliter(Predicate <? super T> predicate)
 * fliter过滤方法
 **/
public class Stream_fliter {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("aaa", "acb", "bcd");
        stream.filter(s->s.startsWith("a")).forEach(System.out::println);
    }
}
