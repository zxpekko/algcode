package dynamicprogramming;

/**
 * @Author:zxp
 * @Description:给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 *
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 *
 * 输入：amount = 10, coins = [10]
 * 输出：1
 * @Date:18:40 2023/12/3
 */
public class Change {
    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(change.change(3, new int[]{2}));
        ChangeⅡ changeⅡ = new ChangeⅡ();
        System.out.println(changeⅡ.change(5, new int[]{1, 2, 5}));
    }
    public int change(int amount, int[] coins){
        int[] dp = new int[amount + 1];//dp[j]表示装满j容量大小的背包的方案总数。
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
class ChangeⅡ{
    public int change(int amount, int[] coins){
        int[] dp = new int[amount + 1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
