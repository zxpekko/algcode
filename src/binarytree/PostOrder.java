package binarytree;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
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
class PostOrderⅠ{
    public List<Integer> postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result=new ArrayList<>();
        List<Integer> midReuslt=new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            midReuslt.add(pop.val);
            if(pop.left!=null)
                stack.push(pop.left);
            if(pop.right!=null)
                stack.push(pop.right);
        }
        for(int i=midReuslt.size()-1;i>=0;i--)
            result.add(midReuslt.get(i));
        return result;
    }
}
class PostOrderⅡ{
    public void postOrder1(TreeNode root,List<TreeNode> result){
        if(root==null)
            return;
        postOrder1(root.left,result);
        postOrder1(root.right,result);
        result.add(root);
    }
    public void postOrder(TreeNode root,List<TreeNode> result){
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<TreeNode> midResult=new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            midResult.add(pop);
            if(pop.left!=null)
                stack.push(pop.left);
            if(pop.right!=null)
                stack.push(pop.right);
        }
        for(int i=midResult.size()-1;i>=0;i++){
            result.add(midResult.get(i));
        }
    }
}
