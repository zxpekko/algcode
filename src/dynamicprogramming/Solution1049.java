package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:13 2024/5/31
 */
public class Solution1049 {
    public static void main(String[] args) {
        Solution1049 solution1049 = new Solution1049();
        System.out.println(solution1049.lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
    public int lastStoneWeightII(int[] stones){
        int sum=0;
        for(int stone:stones)
            sum+=stone;
        int mid=sum/2;
        int[] dp = new int[mid + 1];
        for(int i=0;i<stones.length;i++){
            for(int j=mid;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        return sum-2*dp[mid];
    }
}
