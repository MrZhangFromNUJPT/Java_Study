package LeetCode.数组.二分搜索;
/**
给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
进阶：不要使用任何内置的库函数，如sqrt 。
*/
public class Valid_Perfect_Square_367 {
    public boolean isPerfectSquare(int num) {
            if(num==0||num==1)
                return true;
            long left = 0;
            long right = num/2;
            while(left<=right){
                long middle = (left+right)/2;
                if(middle*middle==num)
                    return true;
                else if(middle*middle>num)
                    right = middle-1;
                else
                    left = middle+1;
            }
            return false;
    }
}
