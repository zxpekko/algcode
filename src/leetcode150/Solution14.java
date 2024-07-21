package leetcode150;

import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:26 2024/7/21
 */
public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
    public String longestCommonPrefix(String[] strs){
        int result=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            min= Math.min(min,strs[i].length());
        }
        for(int i=0;i<min;i++){
            char pre=strs[0].charAt(i);
            boolean flag=false;
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=pre){
                    flag=true;
                    break;
                }
            }
            if(!flag)
                result++;
            else break;
        }
        if(result>0)
            return strs[0].substring(0,result);
        return "";
    }
}
