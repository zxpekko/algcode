package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:39 2024/7/14
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length==0)
            return null;

        return toBST(nums,0,nums.length-1);
    }
    public TreeNode toBST(int[] nums,int left,int right){
        if(left>right)
            return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=toBST(nums,left,mid-1);
        root.right=toBST(nums,mid+1,right);
        return root;
    }
}
