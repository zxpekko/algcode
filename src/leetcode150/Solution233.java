package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:29 2024/8/18
 */
public class Solution233 {
    public static void main(String[] args) {
        Solution233 solution233 = new Solution233();
        System.out.println(solution233.countDigitOne(13));
    }

    int[][] dp;
    char[] s;

    public int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length][s.length];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        return f(0, 0, true);
    }

    public int f(int i, int cnt, boolean isLimit) {
        if (i == s.length)
            return cnt;
        if (!isLimit && dp[i][cnt] != -1)
            return dp[i][cnt];
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            res += f(i + 1, cnt + (d == 1 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit)
            dp[i][cnt] = res;
        return res;
    }
}
class Solution233Ⅰ{
    int[][] dp;
    char[] s;
    public int countDigitThree(int n){
        s=Integer.toString(n).toCharArray();
        dp=new int[s.length][s.length];
        for(int[] arr: dp)
            Arrays.fill(arr,-1);
        return 0;
    }
    public int f(int i,int cnt3,boolean isLimit){
        if(i==s.length)
            return cnt3;
        if(!isLimit&&dp[i][cnt3]!=-1)
            return dp[i][cnt3];
        int res=0;
        int up=isLimit?s[i]-'0':9;
        for(int d=0;d<=up;d++){
            res+=f(i+1,cnt3+(d==3?1:0),isLimit && d==up);
        }
        if(!isLimit)
            dp[i][cnt3]=res;
        return res;
    }
}