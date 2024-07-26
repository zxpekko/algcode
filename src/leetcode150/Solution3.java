package leetcode150;

import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:36 2024/7/24
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s){
        int n=s.length(),right=-1;
        int result=0;
        HashSet<Character> record=new HashSet<>();
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
