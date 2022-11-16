package Study.Stream_Study;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author ZhiPengZhang
 * @date 2022/10/26 20:22
 * @description Stream流的创建
 **/
public class GetStream {
    public static void main(String[] args) {
        //List集合转换为Stream流
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        //Set集合转换为Stream流
        HashSet<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();
        //Map集合转换为Stream流，双列转换为单列，再转换为Stream流
        HashMap<String, Integer> map = new HashMap<>();
        //键值对
        Set<Map.Entry<String, Integer>> set1 = map.entrySet();
        Stream<Map.Entry<String, Integer>> stream3 = set1.stream();
        //键
        Set<String> set2 = map.keySet();
        Stream<String> stream4 = set2.stream();
        //值
        Collection<Integer> values = map.values();
        Stream<Integer> stream5 = values.stream();

        //数组
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);
        Integer[] integers ={1,2,3,4,5};
        Stream<Integer> stream7 = Stream.of(integers);
        Stream<Integer> stream8 = Arrays.stream(integers, 1, 3);


    }
}
