package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:49 2024/8/16
 */
public class Solution191 {
    public static void main(String[] args) {
        Solution191 solution191 = new Solution191();
        System.out.println(solution191.hammingWeight(128));
    }
    public int hammingWeight(int n){
        int count=0;
        while (n>0){
            if(n%2==1)
                count++;
            n/=2;
        }
        return count;
    }
}
