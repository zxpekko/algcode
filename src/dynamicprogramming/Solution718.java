package dynamicprogramming;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:39 2024/4/25
 */
public class Solution718 {
    public static void main(String[] args) {
        Solution718 solution718 = new Solution718();
        System.out.println(solution718.findLength(new int[]{0,0,0,0,0}, new int[]{0,0,0,0,0}));
        Solution718Ⅰ solution718Ⅰ = new Solution718Ⅰ();
        System.out.println(solution718Ⅰ.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
    public int findLength(int[] nums1, int[] nums2){
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    if(i>0&&j>0)
                        dp[i][j]=dp[i-1][j-1]+1;
                    else
                        dp[i][j]=1;
                }
            }
        }
        int max=dp[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=(Math.max(dp[i][j], max));
            }
        }
        return max;
    }
}
class Solution718Ⅰ{
    public int findLength(int[] nums1, int[] nums2){
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    if(i>0&&j>0)
                        dp[i][j]=dp[i-1][j-1]+1;
                    else
                        dp[i][j]=1;
                }
            }
        }
        int max=dp[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
