package LeetCode.字符串;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Reverse_String_344 {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int i = 0;
        while(i<str.length){
            if(str.length-i<k)
                reverse(str,i,str.length-1);
            else
                reverse(str,i,i+k-1);
            i+=2*k;
        }
        return new String(str);
    }
    public void reverse(char[] s,int i,int j){
        while(i<j){
            s[i]^=s[j];
            s[j]^=s[i];
            s[i]^=s[j];
            i++;
            j--;
        }
    }
}
