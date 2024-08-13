package leetcode150;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:18 2024/8/8
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack=new Stack<>();
        int index=0;
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                index++;
                if(index==k)
                    return pop.val;
                cur=pop.right;
            }
        }
        return 0;
    }
}
