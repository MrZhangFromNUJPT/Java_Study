package LeetCode.字符串;
/**
 *给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * */
public class Reverse_String_II_541 {
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
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
