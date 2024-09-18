package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:46 2024/8/26
 */
public class Solution3265 {
    public static void main(String[] args) {
        Solution3265 solution3265 = new Solution3265();
        System.out.println(solution3265.countPairs(new int[]{1,1,1,1,1}));
    }
    public int countPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(judge(nums[i],nums[j]))
                    count++;
            }
        }
        return count;
    }
    public boolean judge(int x,int y){
        int big=Math.max(x,y);
        int small=Math.min(x,y);
        if(x==y)
            return true;
        if(big<10)
            return false;
        List<Integer> nums=new ArrayList<>();
        List<Integer> pow=new ArrayList<>();
        int curPow=1;
        while (big>0){
            nums.add(big%10);
            pow.add(curPow);
            big/=10;
            curPow*=10;
        }
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                int number=0;
                for(int k=0;k<nums.size();k++){
                    if(k==i)
                        number+=(nums.get(i)*pow.get(j));
                    else if(k==j)
                        number+=(nums.get(j)*pow.get(i));
                    else number+=(nums.get(k)*pow.get(k));
                }
                if(number==small)
                    return true;
            }
        }
        return false;
    }
}