package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:51 2024/8/18
 */
public class CountDigit {
    public static void main(String[] args) {

    }
    int[][] dp;
    char[] s;
    public int countDigit(int n,int x){
        s=Integer.toString(n).toCharArray();
        dp=new int[s.length][s.length];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        return f(0,0,x,true);
    }
    public int f(int i,int cntx,int x,boolean isLimit){
        if(i==s.length)
            return cntx;
        if(!isLimit&&dp[i][cntx]!=-1)
            return dp[i][cntx];
        int up=isLimit?s[i]-'0':9;
        int res=0;
        for(int d=0;d<=up;d++){
            res+=f(i+1,cntx+(d==x?1:0),x,isLimit && d==up);
        }
        if(!isLimit)
            dp[i][cntx]=res;
        return res;
    }
}
