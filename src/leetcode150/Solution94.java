package leetcode150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:46 2024/9/9
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root){
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                cur=pop.right;
            }
        }
        return result;
    }
}
