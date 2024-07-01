package binarytree;

import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:58 2024/6/24
 */
public class Kmin {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        treeNode1.left=treeNode;
        treeNode1.right=treeNode2;
        Kmin kmin = new Kmin();
        System.out.println(kmin.getK(treeNode1, 2));

    }
    public int getK(TreeNode root,int k){
        if(root==null)
            return Integer.MIN_VALUE;
        int curK=0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else {
                TreeNode pop = stack.pop();
                curK++;
                cur=pop.right;
                if(curK==k)
                    return pop.val;
            }
        }
        return 0;
    }
}
