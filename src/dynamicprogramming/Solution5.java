package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:51 2024/5/18
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s){
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<dp.length;i++){
            dp[i][i]=true;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1<=j-1)
                        dp[i][j]=dp[i+1][j-1];
                    else dp[i][j]=true;
                }
                else
                    dp[i][j]=false;
            }
        }
        int maxLength=0;
        String result=null;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]&&j-i+1>maxLength){
                    maxLength=j-i+1;
                    result=s.substring(i,j+1);
                }
            }
        }
        return result;
    }
}
