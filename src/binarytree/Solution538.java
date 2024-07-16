package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:35 2024/7/14
 */
public class Solution538 {
    int index=0;
    public TreeNode convertBST(TreeNode root){
        if(root==null)
            return null;
        List<Integer> result=new ArrayList<>();
        inorder(root,result);
        int[] post = new int[result.size()];
        post[post.length-1]=result.get(result.size()-1);
        for(int i=post.length-2;i>=0;i--){
            post[i]=result.get(i)+post[i+1];
        }
        inorder(root,post);
        return root;
    }
    public void inorder(TreeNode root, List<Integer> result){
        if(root==null)
            return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
    public void inorder(TreeNode root,int[] post){
        if(root==null)
            return;
        inorder(root.left,post);
        root.val=post[index++];
        inorder(root.right,post);
    }
}
class Solution538Ⅰ{
    TreeNode pre=null;
    public TreeNode convertBST(TreeNode root){
        if(root==null)
            return null;
        inorder(root);
        return root;
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.right);
        if(pre!=null){
            root.val+=pre.val;
        }
        pre=root;
        inorder(root.left);
    }
}
