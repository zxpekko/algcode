package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:42 2024/5/31
 */
public class Solution474 {
    public static void main(String[] args) {
        Solution474 solution474 = new Solution474();
        System.out.println(solution474.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));

    }
    public int findMaxForm(String[] strs, int m, int n){
        int[][] dp = new int[m + 1][n + 1];//dp[i][j]最多i个0和j个1，最多几个字符串
        for(int i=0;i<strs.length;i++){
            int[] zeroAndOne = getZeroAndOne(strs[i]);
            for(int j=m;j>=zeroAndOne[0];j--){
                for(int k=n;k>=zeroAndOne[1];k--){
                    dp[j][k]=Math.max(dp[j][k],dp[j-zeroAndOne[0]][k-zeroAndOne[1]]+1);
                }
            }
        }
        return dp[m][n];
    }
    public int[] getZeroAndOne(String str){
        int[] result = new int[2];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')
                result[0]++;
            else result[1]++;
        }
        return result;
    }
}
