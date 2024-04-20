package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:06 2024/4/5
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==p||root==q||root==null)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)
            return root;
        else if(left!=null&&right==null)
            return left;
        else return right;
    }
//    public TreeNode find(TreeNode root,TreeNode p,TreeNode q){
//        if(root==p||root==q||root==null)
//            return root;
//        TreeNode left=find(root.left,p,q);
//        TreeNode right=find(root.right,p,q);
//        if(left!=null&&right!=null)
//            return root;
//        else if(left!=null&&right==null)
//            return left;
//        else if(left==null&&right!=null)
//            return right;
//        return null;
//    }
}
class Solution236Ⅰ{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==p||root==q||root==null)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)
            return root;
        else if(left!=null&&right==null)
            return left;
        else return right;
//        return null;
    }
}