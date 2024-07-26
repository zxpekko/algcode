package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:55 2024/7/22
 */
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(new int[]{1, 1}));
    }
    public int maxArea(int[] height){
        int n=height.length;
        int left=0,right=n-1;
        int result=0;
        while (left<right){
            int w=right-left;
            int h=Math.min(height[left],height[right]);
            result=Math.max(result,w*h);
            if(height[left]<height[right])
                left++;
            else right--;
        }
        return result;
    }
}