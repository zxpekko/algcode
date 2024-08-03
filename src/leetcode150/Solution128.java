package leetcode150;

import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:33 2024/7/29
 */
public class Solution128 {
    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        Solution128Ⅰ solution128Ⅰ = new Solution128Ⅰ();
        System.out.println(solution128Ⅰ.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
    public int longestConsecutive(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!hashSet.contains(nums[i]-1)){
                int curNum=nums[i];
                int curLength=1;
                while (hashSet.contains(curNum+1)){
                    curNum++;
                    curLength++;
                }
                max=Math.max(max,curLength);
            }
        }
        return max;
    }
}
class Solution128Ⅰ{
    public int longestConsecutive(int[] nums){
        HashSet<Integer> record=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            record.add(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(!record.contains(nums[i]-1)){
                int curNum=nums[i];
                int curLength=1;
                while (record.contains(curNum+1)){
                    curNum++;
                    curLength++;
                }
                max=Math.max(max,curLength);
            }
        }
        return max;
    }
}