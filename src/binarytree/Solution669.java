package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:25 2024/7/15
 */
public class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high){
        if(root==null)
            return null;
        if(root.val<low){
            TreeNode right=trimBST(root.right,low,high);
            return right;
        }
        if(root.val>high){
            TreeNode left=trimBST(root.left,low,high);
            return left;
        }
        TreeNode left=trimBST(root.left,low,high);
        TreeNode right=trimBST(root.right,low,high);
        return root;
    }
}
