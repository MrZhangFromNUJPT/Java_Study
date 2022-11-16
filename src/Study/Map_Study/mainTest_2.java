package Study.Map_Study;

import java.util.*;

public class mainTest_2 {
    public static void main(String[] args) {
        HashMap<String,Employee> hashMap = new HashMap<>();
        hashMap.put("001",new Employee("001","季一木",18010));
        hashMap.put("002",new Employee("002","王海艳",17000));
        hashMap.put("003",new Employee("003","张代远",19000));
/*
    六种遍历方式，主要是keySet、values、entrySet各两种（增强for和迭代器）
 */


//      (1)使用keySet
//      ①增强for循环
        Set<String> keySet = hashMap.keySet();     //key是String类型
        for (String key: keySet) {
            System.out.println(key+"-"+hashMap.get(key));
        }
//      ②迭代器
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key =  iterator.next();
            System.out.println(key+"-"+hashMap.get(key));
        }

//      (2)使用values
        Collection<Employee> values = hashMap.values();

//      (3)使用entrySet,类型为Map.Entry<E1,E2>，这种类型有getKey和getValue方法
//      ①增强for
        Set<Map.Entry<String, Employee>> entries = hashMap.entrySet();
        for (Map.Entry<String, Employee> en:entries) {
            System.out.println(en.getKey()+"========"+en.getValue());
        }
//      ②迭代器
        Iterator<Map.Entry<String, Employee>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Employee> next =  iterator1.next();
            System.out.println(next.getKey()+"========"+next.getValue());
        }
    }
}
