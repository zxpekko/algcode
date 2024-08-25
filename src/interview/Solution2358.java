package interview;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:05 2024/8/25
 */
public class Solution2358 {
    public static void main(String[] args) {
        Solution2358 solution2358 = new Solution2358();
        System.out.println(solution2358.maximumGroups(new int[]{10, 6, 12, 7, 3, 5}));
    }
    public int maximumGroups(int[] grades){
        int n=grades.length;
        int res=(int)Math.floor((-1+Math.pow(1+8*n,0.5))/2);
        if((res+1)*(res+2)/2<=n)
            res++;
        return res;
    }
}
