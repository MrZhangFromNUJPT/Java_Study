package com.company;


import java.util.*;

/**
 * @author ZhiPengZhang
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int i = 0;
        i= i ++;
        System.out.println(i);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int j : nums1) {
            hashSet1.add(j);
        }
        for (int j : nums2) {
            if (hashSet1.contains(j)) {
                hashSet2.add(j);
            }
        }
        int[] restlt = new int[hashSet2.size()];
        int len = 0;
        for (int j : hashSet2) {
            restlt[len++] = j;
        }
        return restlt;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int num;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                num = hashMap.getOrDefault(i + j, 0) + 1;
                hashMap.put(i + j, num);
            }
        }
        num = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                if (hashMap.containsKey(-i - j)) {
                    num += hashMap.get(-i - j);
                }
            }
        }
        return num;
    }

    public int partitionDisjoint(int[] nums) {
        //创建一个数组，记录该位置后面(不包括这个位置)最小的值
        int[] largest = new int[nums.length - 1];
        int small = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; i--) {
            small = Math.min(small, nums[i]);
            largest[i - 1] = small;
        }
        int big = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            big = Math.max(big, nums[i]);
            if (big <= largest[i]) {
                return i + 1;
            }
        }
        return nums.length;
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] chars = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        chars = s.toCharArray();
        int length = Integer.MAX_VALUE;
        int num = map.size();//记录非零个数
        String answer = "";
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (map.containsKey(chars[j])) {
                map.put(chars[j], map.get(chars[j]) - 1);
                if (map.get(chars[j]) == 0) {
                    num--;
                }
            }
            while (num == 0) {
                if (!map.containsKey(chars[i])) {
                    i++;
                } else if (map.get(chars[i]) < 0) {
                    map.put(chars[i], map.get(chars[i]) + 1);
                    i++;
                } else {
                    if (length > j - i + 1) {
                        length = j - i + 1;
                        answer = s.substring(i, j + 1);
                    }
                    map.put(chars[i], map.get(chars[i]) + 1);
                    i++;
                    num++;
                    break;
                }
            }
        }
        return answer;
    }

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        for (String str : s1) {
            str.trim();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!"".equals(s1[i])) {
                stringBuilder.append(s1[i]).append(" ");
            }
        }
        return new String(stringBuilder.substring(0, stringBuilder.length() - 1));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;
        int[] next = getNext(s);
        if (next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0)
            return true;
        return false;
    }

    public static int[] getNext(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }


}

