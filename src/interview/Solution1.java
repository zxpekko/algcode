package interview;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:38 2024/8/17
 */
public class Solution1 {
    public boolean hasPathSum (TreeNode root, int sum){
        if(root==null)
            return false;
        if(root.left==null&&root.right==null&&sum-root.val==0)
            return true;
        if(root.left==null&&root.right==null)
            return false;
        boolean l = hasPathSum(root.left, sum-root.val);
        boolean r = hasPathSum(root.right, sum-root.val);
        return l||r;
    }
}
