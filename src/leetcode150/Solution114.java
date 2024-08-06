package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:32 2024/8/5
 */
public class Solution114 {
    List<TreeNode> list=new ArrayList<>();
    public void flatten(TreeNode root){
        preorder(root);
        TreeNode p=root;
        for(int i=1;i<list.size();i++){
            p.right=list.get(i);
            p.left=null;
            p=p.right;
        }
    }
    public void preorder(TreeNode root){
        if(root==null)
            return;
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
    public void flatten1(TreeNode root){
        if(root==null)
            return;

    }
}
