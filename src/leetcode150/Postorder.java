package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:49 2024/8/7
 */
public class Postorder {
    List<Integer> res=new ArrayList<>();
    public void postorder(TreeNode root){
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        res.add(root.val);
    }
    public List<Integer> post(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(pop.left!=null)
                stack.push(pop.left);
            if(pop.right!=null)
                stack.push(pop.right);
        }
        List<Integer> last=new ArrayList<>();
        for(int i=result.size()-1;i>=0;i--)
            last.add(result.get(i));

        return last;
    }
}
