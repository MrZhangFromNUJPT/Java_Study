package LeetCode.数组.二分搜索;

/**
给你一个非负整数 x ，计算并返回x的算术平方根。
由于返回类型是整数，结果只保留整数部分，小数部分将被舍去。
注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
*/
public class Sqrt_x_69 {

    //暴力
    public int mySqrt(int x) {
        long answer = -1;
        long i = 1;
        while (i * i <= x) {
            answer = i;
            i++;
        }
        return (int) answer;
    }

    //二分法
    public int mySqrt_2(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (middle > x / middle)
                right = middle - 1;
            else if (middle == x / middle)
                return middle;
            else {
                left = middle + 1;
            }
        }
        return right;
    }
}

