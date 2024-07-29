package leetcode150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:16 2024/7/29
 */
public class Solution202 {
    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        System.out.println(solution202.isHappy(3));
    }
    public boolean isHappy(int n){
        HashSet<Integer> hashSet=new HashSet<>();
        while (n!=1){
            int sum=0;
            while (n>0){
                int mod=n%10;
                sum+=mod*mod;
                n/=10;
            }
            n=sum;
            if(hashSet.contains(sum))
                return false;
            else hashSet.add(sum);
        }
        return true;
    }
}
