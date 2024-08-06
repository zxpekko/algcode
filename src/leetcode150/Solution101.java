package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:02 2024/8/4
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root){
        if(root==null)
            return true;
        return judge(root.left,root.right);
    }
    public boolean judge(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        if(root1!=null&&root2!=null&&root1.val==root2.val)
            return judge(root1.left,root2.right)&&judge(root1.right,root2.left);
        return false;
    }
}
