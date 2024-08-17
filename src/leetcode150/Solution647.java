package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:41 2024/8/3
 */
public class Solution647 {
    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        System.out.println(solution647.countSubstrings("abc"));
        Solution647Ⅰ solution647Ⅰ = new Solution647Ⅰ();
        System.out.println(solution647Ⅰ.countSubstrings("abc"));
    }
    public int countSubstrings(String s){
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1>j-1)
                        dp[i][j]=true;
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
class Solution647Ⅰ{
    public int countSubstrings(String s){
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i+1>j-1)
                        dp[i][j]=true;
                    else
                        dp[i][j]=dp[i+1][j-1];
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                count+=(dp[i][j]?1:0);
            }
        }
        return count;
    }
}