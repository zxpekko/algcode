package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:17 2024/4/8
 */
public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val){
        if(root==null){
            TreeNode treeNode = new TreeNode();
            treeNode.val=val;
            return treeNode;
        }
        else if(root.val>val)
            root.left=insertIntoBST(root.left,val);
        else root.right=insertIntoBST(root.right,val);
        return root;
    }
}
