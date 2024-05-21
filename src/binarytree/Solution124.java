package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:42 2024/5/20
 */
public class Solution124 {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }
    public int maxGain(TreeNode root){
        if(root==null)
            return 0;
        int left=Math.max(maxGain(root.left),0);
        int right=Math.max(maxGain(root.right),0);
        int current=root.val+left+right;
        maxSum=Math.max(maxSum,current);
        return root.val+Math.max(left,right);
    }
}
