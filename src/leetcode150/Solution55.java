package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:41 2024/7/17
 */
public class Solution55 {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump(new int[]{3, 2, 1, 0, 4}));
        Solution55Ⅰ solution55Ⅰ = new Solution55Ⅰ();
        System.out.println(solution55Ⅰ.canJump(new int[]{3, 2, 1, 0, 4}));
        Solution55Ⅱ solution55Ⅱ = new Solution55Ⅱ();
        System.out.println(solution55Ⅱ.canJump(new int[]{3, 2, 1, 0, 4}));
    }
    public boolean canJump(int[] nums){
        int n=nums.length;
        int position=n-1;
        boolean flag;
        while (position>0){
            flag=false;
            for(int i=0;i<position;i++){
                if(i+nums[i]>=position){
                    position=i;
                    flag=true;
                    break;
                }
            }
            if(!flag)
                return false;
        }
        return true;
    }
}
class Solution55Ⅰ{
    public boolean canJump(int[] nums){
        int n=nums.length;
        int right=0;
        for(int i=0;i<n;i++){
            if(i<=right){
                right=Math.max(right,i+nums[i]);
                if(right>=n-1)
                    return true;
            }
        }
        return false;
    }
}
class Solution55Ⅱ{
    public boolean canJump(int[] nums){
        int n=nums.length;
        int rightmost=0;
        for(int i=0;i<n;i++){
            if(i<=rightmost){
                rightmost=Math.max(rightmost,i+nums[i]);
            }
            else return false;
        }
        return true;
    }
}
class Solution55Ⅲ{
    public boolean canJump(int[] nums){
        int rightmost=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i<=rightmost){
                rightmost=Math.max(rightmost,i+nums[i]);
                if(rightmost>=n-1)
                    return true;
            }
            else
                return false;
        }
        return false;
    }
}