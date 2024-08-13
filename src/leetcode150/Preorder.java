package leetcode150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:42 2024/8/7
 */
public class Preorder {
    List<Integer> res=new ArrayList<>();
    public void preorder(TreeNode root){
        if(root==null)
            return;
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public void pre(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.right!=null)
                stack.push(pop.right);
            if(pop.left!=null)
                stack.push(pop.left);
        }
    }
}