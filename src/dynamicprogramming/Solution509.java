package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:05 2024/7/15
 */
public class Solution509 {
    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        System.out.println(solution509.fib(10));
        System.out.println(solution509.fib1(10));
        System.out.println(solution509.fib2(10));
    }
    public int fib(int n){
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int fib1(int n){
        int p=0,q=1;
        int m=p+q;
        for(int i=2;i<=n;i++){
            m=p+q;
            p=q;
            q=m;
        }
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        return m;
    }
    public int fib2(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fib2(n-1)+fib2(n-2);
    }
}
