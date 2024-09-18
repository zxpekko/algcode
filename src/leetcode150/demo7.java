package leetcode150;

public class demo7 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int length = nums.length;
        int val = 0;
        while (r < nums.length) {
            if (val >= target) {
                if (r - l < length)
                    length = r - l;
                val -= nums[l];
                l++;
            } else {
                val += nums[r++];
//                if (l != 0)
//                    val -= nums[l--];
            }
        }
        return length;
    }
}
