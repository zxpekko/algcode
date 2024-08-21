package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:18:07 2024/8/19
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length==0)
            return null;
        return sort(nums,0,nums.length-1);
    }
    public TreeNode sort(int[] nums,int left,int right){
        if(left>right)
            return null;
        int mid=(left+right)/2;
        TreeNode root = new TreeNode();
        root.val=nums[mid];
        root.left=sort(nums,left,mid-1);
        root.right=sort(nums,mid+1,right);
        return root;
    }
}
