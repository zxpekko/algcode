package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:18:41 2024/8/6
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null)
            return false;
        return judge(root,targetSum-root.val);
    }
    public boolean judge(TreeNode root,int targetSum){
        if(root.left==null&&root.right==null&&targetSum==0)
            return true;
        if(root.left==null&&root.right==null)
            return false;
        if(root.left!=null){
            if(judge(root.left,targetSum-root.left.val))
                return true;
        }
        if(root.right!=null){
            if(judge(root.right,targetSum-root.right.val))
                return true;
        }
        return false;
    }
}
