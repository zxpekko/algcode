package leetcode150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:55 2024/8/7
 */
public class Inorder {
    public static void main(String[] args) {

    }
    public List<Integer> inorder(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
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
    List<Integer> res=new ArrayList<>();
    public void in(TreeNode root){
        if(root==null)
            return;
        in(root.left);
        in(root.right);
        res.add(root.val);
    }
}