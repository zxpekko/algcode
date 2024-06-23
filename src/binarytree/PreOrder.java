package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:27 2024/4/4
 */
public class PreOrder {
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result=new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.right!=null)
                stack.push(pop.right);
            if(pop.left!=null)
                stack.push(pop.left);
        }
    }
    public List<Integer> preOrderⅠ(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result=new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.right!=null)
                stack.push(pop.right);
            if(pop.left!=null)
                stack.push(pop.left);
        }
        return result;
    }
}