package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:17 2024/8/25
 */
public class Solution172 {
    public static void main(String[] args) {
        Solution172 solution172 = new Solution172();
        System.out.println(solution172.trailingZeroes(5));
    }
    public int trailingZeroes(int n){
        int res=0;
        for(int i=5;i<=n;i+=5){
            for(int x=i;x%5==0;x/=5){
                res++;
            }
        }
        return res;
    }

}