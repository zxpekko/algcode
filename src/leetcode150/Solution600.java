package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:49 2024/8/5
 */
public class Solution600 {
    public static void main(String[] args) {
        Solution600 solution600 = new Solution600();
        System.out.println(solution600.findIntegers(5));
    }
    public int findIntegers(int n){
        int count=0;
        for(int i=0;i<=n;i++){
            if(!hasLianxu(i)){
                count++;
            }
        }
        return count;
    }
    public boolean hasLianxu(int n){
        int count=0;
        while (n>0){
            if(n%2==1){
                count++;
                if(count==2)
                    return true;
            }
            else {
                count=0;
            }
            n/=2;
        }
        return false;
    }
}