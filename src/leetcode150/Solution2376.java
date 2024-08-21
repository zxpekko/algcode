package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:43 2024/8/18
 */
public class Solution2376 {
    public static void main(String[] args) {
        Solution2376 solution2376 = new Solution2376();
        System.out.println(solution2376.countSpecialNumbers(20));
        Solution2376Ⅰ solution2376Ⅰ = new Solution2376Ⅰ();
        System.out.println(solution2376Ⅰ.countSpecialNumbers(20));
    }
    char[] s;
    int[][] dp;
    public int countSpecialNumbers(int n){
        s=Integer.toString(n).toCharArray();
        dp=new int[s.length][1<<10];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return num(0,0,true,false);
    }
    public int num(int i,int mask,boolean isLimit,boolean isNum){
        if(i==s.length)
            return isNum?1:0;
        if(!isLimit&&isNum&&dp[i][mask]!=-1)
            return dp[i][mask];
        int res=0;
        if(!isNum)
            res=num(i+1,mask,false,false);
        int up=isLimit?s[i]-'0':9;
        for(int d=(isNum?0:1);d<=up;d++){
            if((mask>>d&1)==0){
                res+=num(i+1,mask|(1<<d),isLimit && d==up,true);
            }
        }
        if(!isLimit&&isNum)
            dp[i][mask]=res;
        return res;
    }
}
class Solution2376Ⅰ{
    int[][] dp;
    char[] s;
    public int countSpecialNumbers(int n){
        s=Integer.toString(n).toCharArray();
        dp=new int[s.length][1<<10];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        return f(0,0,true,false);
    }
    public int f(int i,int mask,boolean isLimit,boolean isNum){
        if(i==s.length)
            return isNum?1:0;
        if(!isLimit&&isNum&&dp[i][mask]!=-1)
            return dp[i][mask];
        int res=0;
        if(!isNum)
            res=f(i+1,mask,false,false);
        int up=isLimit?s[i]-'0':9;
        for(int d=(isNum?0:1);d<=up;d++){
            if((mask>>d&1)==0)
                res+=(f(i+1,mask|(1<<d),isLimit && d==up,true));
        }
        if(!isLimit&&isNum)
            dp[i][mask]=res;
        return res;
    }
}