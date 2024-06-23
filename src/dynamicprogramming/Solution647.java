package dynamicprogramming;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:16 2024/4/19
 */
public class Solution647 {
    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        System.out.println(solution647.countSubstrings("aaa"));
        Solution647Ⅱ solution647Ⅱ = new Solution647Ⅱ();
        System.out.println(solution647Ⅱ.countSubstrings("aaa"));
        Solution647Ⅲ solution647Ⅲ = new Solution647Ⅲ();
        System.out.println(solution647Ⅲ.countSubstrings("aaa"));
    }
    public int countSubstrings(String s){
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1<=j-1)
                        dp[i][j]=dp[i+1][j-1];
                    else
                        dp[i][j]=true;
                }
                else
                    dp[i][j]=false;
            }
        }
//        for(int i=0;i<n;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result+=(dp[i][j]?1:0);
            }
        }
        return result;
    }
}
class Solution647Ⅱ{
    public int countSubstrings(String s){
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1<=j-1)
                        dp[i][j]=dp[i+1][j-1];
                    else dp[i][j]=true;
                }
            }
        }
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result+=(dp[i][j]?1:0);
            }
        }
        return result;
    }
}
class Solution647Ⅲ{
    public int countSubstrings(String s){
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1>j-1){
                        dp[i][j]=true;
                    }
                    else
                        dp[i][j]=dp[i+1][j-1];
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j])
                    count++;
            }
        }
        return count;
    }
}