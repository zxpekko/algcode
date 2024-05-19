package binarytree;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:06 2024/5/9
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k){
        int curK=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                cur=pop.right;
                curK++;
                if(curK==k)
                    return pop.val;
            }
        }
        return 0;
    }
}
