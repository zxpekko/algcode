package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:54 2024/4/28
 */
public class Solution1035 {
    public static void main(String[] args) {
        Solution1035 solution1035 = new Solution1035();
        System.out.println(solution1035.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        Solution1035Ⅰ solution1035Ⅰ = new Solution1035Ⅰ();
        System.out.println(solution1035Ⅰ.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2){
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
class Solution1035Ⅰ{
    public int maxUncrossedLines(int[] nums1, int[] nums2){
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int max=dp[0][0];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++)
                max=Math.max(max,dp[i][j]);
        }
        return max;
    }
}
