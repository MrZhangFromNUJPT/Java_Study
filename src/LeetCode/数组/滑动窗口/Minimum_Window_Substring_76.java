package LeetCode.数组.滑动窗口;

import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：
对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
*/
public class Minimum_Window_Substring_76 {

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hashMap_add(hashMap, t.charAt(i));
        }
        int left = 0;
        String answer = "";
        int length = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (hashMap.containsKey(s.charAt(right)))
                hashMap_sub(hashMap, s.charAt(right));
            while (allLowerZero(hashMap)) {
                int len = right - left + 1;
                if (len < length) {
                    length = len;
                    answer = s.substring(left, right + 1);
                }
                if (hashMap.containsKey(s.charAt(left)))
                    hashMap_add(hashMap, s.charAt(left));
                left++;
            }
        }
        return answer;
    }

    //key对应的value减一操作
    public void hashMap_sub(HashMap<Character, Integer> hashMap, Character key) {
        int count = hashMap.get(key);
        hashMap.put(key, count - 1);
    }

    //key对应的value加一操作
    public void hashMap_add(HashMap<Character, Integer> hashMap, Character key) {
        if (!hashMap.containsKey(key))
            hashMap.put(key, 1);
        else {
            int count = hashMap.get(key);
            hashMap.put(key, count + 1);
        }
    }

    //判断values是否都<=0
    public boolean allLowerZero(HashMap<Character, Integer> hashMap) {
        Collection<Integer> collection = hashMap.values();
        Iterator<Integer> integerIterator = collection.iterator();
        while (integerIterator.hasNext()) {
            Integer next = integerIterator.next();
            if (next > 0)
                return false;
        }
        return true;
    }
}
