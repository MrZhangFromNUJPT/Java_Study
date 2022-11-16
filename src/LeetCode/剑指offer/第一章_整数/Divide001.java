package LeetCode.剑指offer.第一章_整数;

/**
 * @author ZhiPengZhang
 * @date 2022/11/2 20:48
 * @description 定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [-231, 231-1]。本题中，如果除法结果溢出，则返回 231 - 1
 **/
public class Divide001 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        if (a == Integer.MIN_VALUE && b == 1) {
            return Integer.MIN_VALUE;
        }
        int negative = 2;
        if (a > 0) {
            negative--;
            a = -a;
        }
        if (b > 0) {
            negative--;
            b = -b;
        }
        int result = div(a, b);
        return negative == 1 ? -result : result;
    }

    public int div(int a, int b) {
        int result = 0;
        while (a <= b) {
            int value = b;
            int quotient = 1;
            while (value >= 0xc0000000 && a <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            a -= value;
        }
        return result;
    }
}


