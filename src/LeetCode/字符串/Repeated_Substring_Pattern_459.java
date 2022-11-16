package LeetCode.字符串;


/**
 *给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 */
public class Repeated_Substring_Pattern_459 {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()==1) return false;
        for(int i=1;i<=s.length()/2;i++){
            if(s.length()%i!=0)
                continue;
            String str = s.substring(0,i);
            StringBuilder s1 =new StringBuilder();
            for(int j=0;j<s.length()/i;j++)
                s1.append(str);
            if(s1.toString().equals(s))
                return true;
        }
        return false;
    }
}
