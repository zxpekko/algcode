package binarytree;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:14 2024/4/4
 */
public class PostOrder {
    public void postOrder(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result=new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.left!=null)
                stack.push(pop.left);
            if(pop.right!=null)
                stack.push(pop.right);
        }
        //翻转
    }
}
