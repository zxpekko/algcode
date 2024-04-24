package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:10 2024/4/22
 */
public class Solution80 {
    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        System.out.println(solution80.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
    public int removeDuplicates(int[] nums){
        int count=1;
        int p=0,q=1;
        while (q<nums.length){
            if(nums[p]!=nums[q]){
                nums[p+1]=nums[q];
                p++;
                q++;
                count=1;
            }
            else {
                if(count<2){
                    nums[p+1]=nums[q];
                    p++;
                    q++;
                    count++;
                }
                else {
                    q++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return p+1;
    }
}
