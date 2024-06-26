package array;

import java.util.HashSet;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:38 2024/5/8
 */
public class Solution128 {
    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        Solution128Ⅱ solution128Ⅱ = new Solution128Ⅱ();
        int i = solution128Ⅱ.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }
    public int longestConsecutive(int[] nums){
        HashSet<Integer> record = new HashSet<>();
        for(int num:nums){
            record.add(num);
        }
        int longest=0;
        int curNum=0;
        int curLongest=0;
        for(int num:nums){
            if(!record.contains(num-1)){
                curNum=num;
                curLongest=1;
                while (record.contains(curNum+1)){
                    curNum+=1;
                    curLongest+=1;
                }
                longest= Math.max(longest,curLongest);
            }
        }
        return longest;
    }
}
class Solution128Ⅱ{
    public int longestConsecutive(int[] nums){
        HashSet<Integer> record=new HashSet<>();
        for(int num:nums){
            record.add(num);
        }
        int curNum=0;
        int curLength=0;
        int longest=0;
        for(int num:nums){
            if(!record.contains(num-1)){
                curLength=1;
                curNum=num;
                while (record.contains(curNum+1)){
                    curLength+=1;
                    curNum+=1;
                }
                longest=Math.max(longest,curLength);
            }
        }
        return longest;
    }
}