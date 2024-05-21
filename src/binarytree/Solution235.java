package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:25 2024/4/7
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==p||root==q||root==null)
            return root;
        if(root.val<p.val&&root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        else if(root.val>p.val&&root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        else return root;
//        return null;
    }
}
class Solution235Ⅰ{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.val>root.val&&q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
        else if(p.val<root.val&&q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        else return root;
    }
}
