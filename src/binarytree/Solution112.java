package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:50 2024/6/18
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null)
            return false;
        targetSum-=root.val;
        if(root.left==null&&root.right==null)
            return targetSum==0;
        if(root.left!=null){
            boolean left = hasPathSum(root.left, targetSum);
            if(left)
                return true;
        }
        if(root.right!=null){
            boolean right = hasPathSum(root.right, targetSum);
            if(right)
                return true;
        }
        return false;
    }
//    public int dfs(TreeNode root,int targetSum){
//
//    }
}
