package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:24 2024/7/18
 */
public class Solution80 {
    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        System.out.println(solution80.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
    public int removeDuplicates(int[] nums){
        int p=0,q=1,n=nums.length;
        int count=1;
        while (q<n){
            if(nums[p]==nums[q]){
                if(count<2){
                    nums[p+1]=nums[q];
                    p++;
                    q++;
                    count++;
                }
                else
                    q++;
            }
            else {
                count=1;
                nums[p+1]=nums[q];
                p++;
                q++;
            }
        }
        return p+1;
    }
}
