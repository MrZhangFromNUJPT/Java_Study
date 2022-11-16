package com.company;

/**
 * @author ZhiPengZhang
 * @date 2022/11/3 12:38
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(test());

    }
    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }
}