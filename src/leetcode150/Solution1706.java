package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:17.06
 * @Date:15:57 2024/8/18
 */
public class Solution1706 {
    public static void main(String[] args) {
        Solution1706 solution1706 = new Solution1706();
        System.out.println(solution1706.numberOf2sInRange(25));
    }
    char[] s;
    int[][] dp;
    public int numberOf2sInRange(int n){
        s=Integer.toString(n).toCharArray();
        dp=new int[s.length][s.length];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        return f(0,0,true);
    }
    public int f(int i, int cnt2,boolean isLimit){
        if(i==s.length)
            return cnt2;
        if(!isLimit&&dp[i][cnt2]!=-1)
            return dp[i][cnt2];
        int res=0;
        int up=isLimit?s[i]-'0':9;
        for(int d=0;d<=up;d++){
            res+=f(i+1,cnt2+(d==2?1:0),isLimit && d==up);
        }
        if(!isLimit)
            dp[i][cnt2]=res;
        return res;
    }
}
