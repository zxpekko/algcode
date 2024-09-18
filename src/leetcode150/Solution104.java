package leetcode150;

//import javax.swing.tree.TreeNode;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:42 2024/8/2
 */
public class Solution104 {
    public int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right?left+1:right+1;
    }
}
class Solution14Ⅰ{
    public int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right?left+1:right+1;
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(){}
}