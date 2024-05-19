package array;

import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:38 2024/5/9
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3Ⅰ solution3Ⅰ = new Solution3Ⅰ();
        System.out.println(solution3Ⅰ.lengthOfLongestSubstring("abcabcbb"));
        int n=1000000000;
        System.out.println(n);
    }
    public int lengthOfLongestSubstring(String s){
        int n=s.length();
        HashSet<Character> record=new HashSet<>();
        int result=0;
        int right=-1;
        for(int i=0;i<n;i++){
            if(i!=0)
                record.remove(s.charAt(i-1));
            while (right+1<n&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                right++;
            }
            result=Math.max(result,right-i+1);
        }
        return result;
    }
}
class Solution3Ⅰ{
    public int lengthOfLongestSubstring(String s){
        int right=-1;
        HashSet<Character> record=new HashSet<>();
        int result=0;
        int n=s.length();
        int l=0,r=0;
        for(int i=0;i<n;i++){
            if(i!=0)
                record.remove(s.charAt(i-1));
            while (right+1<n&&!record.contains(s.charAt(right+1))){
                record.add(s.charAt(right+1));
                right++;
            }
//            result=Math.max(result,right-i+1);
            if(result<right-i+1){
                l=i;
                r=right;
                result=right-i+1;
            }
        }
        System.out.println(s.substring(l,r+1));
        return result;
    }
}
