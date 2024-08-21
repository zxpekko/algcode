package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:05 2024/8/18
 */
public class Solution902 {
    public static void main(String[] args) {
        Solution902 solution902 = new Solution902();
        System.out.println(solution902.atMostNGivenDigitSet(new String[]{"1", "4", "9"}, 1000000000));
    }
    int[][] dp;
    char[] s;
    public int atMostNGivenDigitSet(String[] digits, int n){
        s=Integer.toString(n).toCharArray();
        dp=new int[s.length][1<<10];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return f(0,0,true,false,digits);
    }
    public int f(int i,int mask,boolean isLimit,boolean isNum,String[] digits){
        if(i==s.length)
            return isNum?1:0;
        if(!isLimit&&isNum&&dp[i][mask]!=-1)
            return dp[i][mask];
        int res=0;
        if(!isNum)
            res=f(i+1,mask,false,false,digits);
        int up=isLimit?s[i]-'0':9;
        for(String d:digits){
            int down=d.charAt(0)-'0';
            if(down>up) break;
            res+=f(i+1,mask|(1<<down),isLimit && down==up,true,digits);
        }
        if(!isLimit&&isNum)
            dp[i][mask]=res;
        return res;
    }
}
