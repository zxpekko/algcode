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
class PreOrderⅠ{
    private List<TreeNode> result=new ArrayList<>();
    public void preOrder(TreeNode root){
        if(root==null)
            return;
        result.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void preorder1(TreeNode root,List<TreeNode> result){
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop);
            if(pop.right!=null)
                stack.push(pop.right);
            if(pop.left!=null)
                stack.push(pop.right);
        }
    }
}