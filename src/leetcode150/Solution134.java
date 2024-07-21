package leetcode150;

import java.math.BigInteger;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:53 2024/7/19
 */
public class Solution134 {
    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        System.out.println(solution134.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
    public int canCompleteCircuit(int[] gas, int[] cost){
        int n=gas.length;
        int count=0,start=0,cur=0;
        while (start<n){
            count=0;
            cur=start;
            int curGas=gas[start];
            while (count<n){
                if(curGas>=cost[cur%n]){
                    count++;
                    curGas+=gas[(cur+1)%n];
                    curGas-=cost[cur%n];
                    cur++;
                }
                else
                    break;
            }
            if(count<n)
                start=start+count+1;
            else
                return start;
        }
        return -1;
    }
}
