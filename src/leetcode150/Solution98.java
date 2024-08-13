package leetcode150;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:27 2024/8/8
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root){
        int pre=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        boolean first=true;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                if(first){
                    pre=pop.val;
                    first=false;
                }
                else if(pop.val<=pre){
                    return false;
                }
                else
                    pre=pop.val;
                cur=pop.right;
            }
        }
        return true;
    }
}
