package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:26 2024/5/3
 */
public class SumMax {
    public static void main(String[] args) {
        SumMax sumMax = new SumMax();
        System.out.println(sumMax.getMax(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public int getMax(int[] arr){
        int n=arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(i==0)
                dp[i]=arr[i];
            else {
                dp[i]=Math.max(arr[i],dp[i-1]+arr[i]);
            }
        }
        int max=dp[0];
        for(int i=0;i<n;i++)
            max=Math.max(max,dp[i]);
        return max;
    }
}
