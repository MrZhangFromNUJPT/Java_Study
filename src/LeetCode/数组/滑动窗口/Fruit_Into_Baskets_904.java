package LeetCode.数组.滑动窗口;

import java.util.HashMap;

/**
你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
你只有两个篮子，并且每个篮子只能装单一类型的水果。每个篮子能够装的水果总量没有限制。
你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上恰好摘一个水果。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
给你一个整数数组fruits，返回你可以收集的水果的最大数目。
*/
public class Fruit_Into_Baskets_904 {

    //暴力求解
    public int totalFruit(int[] fruits) {
        int firstClass;
        int secondClass = -1;
        int sum = 0;
        int length = 0;
        for (int i = 0; i < fruits.length; i++) {
            firstClass = fruits[i];
            for (int j = i; j < fruits.length; j++) {
                //下一个属于已存在的篮子类型
                if (fruits[j] == firstClass || fruits[j] == secondClass)
                    sum++;
                    //第二个篮子还没放且下一个不属于第一个篮子
                else if (secondClass == -1) {
                    secondClass = fruits[j];
                    sum++;
                } else {
                    secondClass = -1;
                    length = Math.max(sum, length);
                    sum = 0;
                    break;
                }
                if (j == fruits.length - 1) {
                    length = Math.max(sum, length);
                    sum = 0;
                }
            }
        }
        return length;
    }

    //滑动窗口,套用209题的格式
    public int totalFruit_2(int[] fruits) {
        int i = 0;
        //利用HaspMap当篮子
        HashMap<Integer, Integer> basket = new HashMap<>();
        int length = 0;
        int sum = 0;
        for (int j = 0; j < fruits.length; j++) {
            hashMap_add(basket, fruits[j]);
            sum++;
            //判断条件，是否移动左边
            while (basket.size() > 2) {
                hashMap_sub(basket, fruits[i]);
                if (basket.get(fruits[i]) == 0) basket.remove(fruits[i]);
                i++;
                sum--;
            }
            length = Math.max(length, sum);
        }
        return length;
    }

    //key对应的value减一操作
    public void hashMap_sub(HashMap<Integer, Integer> basket, Integer key) {
        int count = basket.get(key);
        basket.put(key, count - 1);
    }

    //key对应的value加一操作
    public void hashMap_add(HashMap<Integer, Integer> basket, Integer key) {
        if (!basket.containsKey(key))
            basket.put(key, 1);
        else {
            int count = basket.get(key);
            basket.put(key, count + 1);
        }
    }
}
