package array;

/**
 * @Author:zxp
 * @Description:给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * @Date:15:43 2024/1/13
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        MinSubArrayLenⅡ minSubArrayLenⅡ = new MinSubArrayLenⅡ();
        System.out.println(minSubArrayLenⅡ.minSubArrayLen(7, new int[]{7, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{7, 3, 1, 2, 4, 3}));
        MinSubArrayLen1 minSubArrayLen1 = new MinSubArrayLen1();
        System.out.println(minSubArrayLen1.minSubArrayLen(7, new int[]{7, 3, 1, 2, 4, 3}));
        MinSubArrayLen2 minSubArrayLen2 = new MinSubArrayLen2();
        System.out.println(minSubArrayLen2.minSubArrayLen(7, new int[]{7, 3, 1, 2, 4, 3}));
        MinSubArrayLen3 minSubArrayLen3 = new MinSubArrayLen3();
        System.out.println(minSubArrayLen3.minSubArrayLen(7, new int[]{7, 3, 1, 2, 4, 3}));
    }
    public int minSubArrayLen(int target, int[] nums){
        int min=Integer.MAX_VALUE;
        int cur=nums[0];
        int right=1;
        for(int left=0;left<nums.length;left++){

            while (cur<target&&right< nums.length){
                cur+=nums[right];
                right++;
            }
            if(cur>=target){
                min=Math.min(min,right-left);
            }
            else if(right== nums.length)
                break;
            cur-=nums[left];
        }
        if(min==Integer.MAX_VALUE)
            return 0;
        return min;
    }

}
class MinSubArrayLenⅡ{
    public int minSubArrayLen(int target, int[] nums){
        //双指针。
        int right=1;
        int min=Integer.MAX_VALUE;
        int current=nums[0];
        for(int left=0;left<nums.length;left++){
            while (current<target&&right<nums.length){
                current+=nums[right];
                right++;
            }
            if(current>=target)
                min=Math.min(min,right-left);
            if(min==Integer.MAX_VALUE)
                return 0;
            current-=nums[left];
        }
        return min;
    }
}
class MinSubArrayLen1{
    public int minSubArrayLen(int target, int[] nums){
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int left=0,right=0;
        int sum=nums[left];
        while (right<n){
            if(sum>=target){
                min=Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }
            else{
                right++;
                if(right<n)
                    sum+=nums[right];
            }
        }
        return min;
    }
}
class MinSubArrayLen2{
    public int minSubArrayLen(int target, int[] nums){
        int result=Integer.MAX_VALUE;
        int n=nums.length;
        int right=-1;
        int curSum=0,i=0;
        while (right<n){
            if(curSum>=target){
                result=Math.min(result,right-i+1);
                curSum-=nums[i];
                i++;
            }
            else {
                right++;
                if(right<n)
                    curSum+=nums[right];
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
class MinSubArrayLen3{
    public int minSubArrayLen(int target, int[] nums){
        int result=Integer.MAX_VALUE;
        int right=-1;
        int index=0;
        int curSum=0;
        while (right<nums.length){
            if(curSum>=target){
                result=Math.min(result,right-index+1);
                curSum-=nums[index];
                index++;
            }
            else {
                right++;
                if(right<nums.length)
                    curSum+=nums[right];
            }
        }
        return result;
    }
}
